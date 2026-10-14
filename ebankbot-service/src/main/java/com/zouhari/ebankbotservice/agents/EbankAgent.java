package com.zouhari.ebankbotservice.agents;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@Service
public class EbankAgent {
    private  ChatClient chatClient;

    private static final String CONVERSATION_ID =
            "ebankbot-demo-qwen-v1";

    public EbankAgent(
            ChatClient.Builder builder,
            ChatMemory chatMemory, ToolCallbackProvider tools) {

        this.chatClient = builder
                .defaultSystem("""
                        Vous un assistant qui se charge de répondre aux question
                        de l'utilisateur à propos des clients et des comptes bancaires, en fonction du contexte fourni.
                        Si aucun contexte n'est fourni, répond avec JE NE SAIS PAS
                        """)
                .defaultAdvisors(
                        MessageChatMemoryAdvisor
                                .builder(chatMemory)
                                .build()
                ).defaultTools(tools.getToolCallbacks())
                .build();
    }

    public String chat(String query) {

        return chatClient.prompt()
                .user(query)
                .advisors(a -> a.param(
                        ChatMemory.CONVERSATION_ID,
                        CONVERSATION_ID
                ))
                .call()
                .content();
    }
}
