package guides.hazelcast.springboot;

import com.hazelcast.map.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CommandController {

    private final String uuid = UUID.randomUUID().toString().substring(0, 5);

    private static final Logger logger = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    @Qualifier("map")
    private IMap<String, String> map;

    @GetMapping("/put")
    public CommandResponse put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        map.put(key, value);
        logger.info("/put with key: {}, value {}", key, value);
        return new CommandResponse(uuid, key, value);
    }

    @GetMapping("/get")
    public CommandResponse get(@RequestParam(value = "key") String key) {
        String value = map.get(key);
        logger.info("/get with key: {}, value {}", key, value);
        return new CommandResponse(uuid, key, value);
    }
}
