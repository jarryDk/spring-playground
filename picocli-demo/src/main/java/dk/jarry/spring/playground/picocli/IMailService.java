package dk.jarry.spring.playground.picocli;

import java.util.List;

public interface IMailService {
    void sendMessage(List<String> to, String subject, String text);
}
