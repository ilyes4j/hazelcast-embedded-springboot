package guides.hazelcast.springboot;

public record CommandResponse (String instance, String key, String value) {
}
