package hello;

public class GreetingExtended {

    private final long id;
    private final String content;
    private final String time;
    private final String server;

    public GreetingExtended(long id, String content, String time, String server) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.server = server;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getServer() {
        return server;
    }
}
