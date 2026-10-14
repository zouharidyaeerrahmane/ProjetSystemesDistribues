
package com.zouhari.ebankbotservice.controllers;

import com.zouhari.ebankbotservice.agents.EbankAgent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class EbankChatbotController {

    private  EbankAgent ebankAgent;

    private static final String CONVERSATION_ID =
            "ebankbot-demo-qwen-v1";

    public EbankChatbotController(EbankAgent ebankAgent) {
        this.ebankAgent = ebankAgent;
    }


    @GetMapping(value = "/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(
            @RequestParam(
                    name = "query",
                    defaultValue = "Bonjour"
            ) String query) {

        return ebankAgent.chat(query);
    }
}
