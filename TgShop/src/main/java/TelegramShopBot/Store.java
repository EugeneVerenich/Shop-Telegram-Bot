package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Store extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "TgShopByEVBot";
    }

    @Override
    public String getBotToken() {
        return "5497552986:AAGPg9zvRqHTAd95c3lqRJjyW2YZp2BsuPQ";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()){
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            
            try{
                execute(message);
            }catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
