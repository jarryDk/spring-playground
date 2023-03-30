package dk.jarry.spring.playground.picocli;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("MailService")
public class MailServiceImpl implements IMailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Override
    public void sendMessage(List<String> to, String subject, String text) {
        LOGGER.info("Mail to {} sent! Subject: {}, Body: {}", to, subject, text);
    }
}