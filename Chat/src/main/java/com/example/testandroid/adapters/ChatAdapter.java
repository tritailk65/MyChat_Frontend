package com.example.testandroid.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testandroid.databinding.ItemReceiveMessageBinding;
import com.example.testandroid.databinding.ItemSentMessageBinding;
import com.example.testandroid.models.ChatMessage;

import java.util.List;

public class ChatAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ChatMessage> chatMessages;
    private final Bitmap receiverProfileImage;
    private final String senderId;
    private final static int VIEW_TYPE_SENT=1;
    private final static int VIEW_TYPE_RECEIVED=2;
    public ChatAdapter(List<ChatMessage> chatMessages, Bitmap receiverProfileImage, String senderId) {
        this.chatMessages = chatMessages;
        this.receiverProfileImage = receiverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==VIEW_TYPE_SENT){
            return new SentMessageViewHolder(ItemSentMessageBinding.inflate(
                    LayoutInflater.from(parent.getContext()),parent,false)
            );
        }else {
            return new ReceiveMessageViewHolder(ItemReceiveMessageBinding.inflate(
                    LayoutInflater.from(parent.getContext()),parent,false
            ));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==VIEW_TYPE_SENT){
            ((SentMessageViewHolder) holder).setData(chatMessages.get(position));
        }else {
            ((ReceiveMessageViewHolder) holder).setData(chatMessages.get(position),receiverProfileImage);
        }
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(chatMessages.get(position).senderId.equals(senderId)){
            return VIEW_TYPE_SENT;
        }else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    static class SentMessageViewHolder extends RecyclerView.ViewHolder{
        private final ItemSentMessageBinding binding;
        SentMessageViewHolder(ItemSentMessageBinding itemSentMessageBinding){
            super(itemSentMessageBinding.getRoot());
            binding=itemSentMessageBinding;
        }
        void setData(ChatMessage chatMessage){
            binding.messageSent.setText(chatMessage.message);
            binding.dateSentmessage.setText(chatMessage.datetime);
        }
    }
    static class ReceiveMessageViewHolder extends RecyclerView.ViewHolder{
        private final ItemReceiveMessageBinding binding;
        ReceiveMessageViewHolder(ItemReceiveMessageBinding itemReceiveMessageBinding){
            super(itemReceiveMessageBinding.getRoot());
            binding=itemReceiveMessageBinding;
        }
        void setData(ChatMessage chatMessage,Bitmap receiverProfileImage){
            binding.messageReceived.setText(chatMessage.message);
            binding.dateReceive.setText(chatMessage.datetime);
            binding.receiveImage.setImageBitmap(receiverProfileImage);
        }
    }
}
