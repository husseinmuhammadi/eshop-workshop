package com.tasnim.trade.eshop.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CartDeserializer extends JsonDeserializer<Cart> {
    @Override
    public Cart deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        TreeNode z = treeNode.get("username");
        return new Cart();
    }
}
