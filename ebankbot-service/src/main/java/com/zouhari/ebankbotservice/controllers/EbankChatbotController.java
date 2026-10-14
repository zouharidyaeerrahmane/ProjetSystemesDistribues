
package com.zouhari.ebankbotservice.controllers;

import com.zouhari.ebankbotservice.agents.EbankAgent;
import org.springframework.web.bind.annotation.*;

@RestController
public class EbankChatbotController {

    private  EbankAgent ebankAgent;

    private static final String CONVERSATION_ID =
            "ebankbot-demo-qwen-v1";

    public EbankChatbotController(EbankAgent ebankAgent) {
        this.ebankAgent = ebankAgent;
    }


    @GetMapping("/chat")
    public String chat(
            @RequestParam(
                    name = "query",
                    defaultValue = "Bonjour"
            ) String query) {

        return ebankAgent.chat(query);
    }
}
