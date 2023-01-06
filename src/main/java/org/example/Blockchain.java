package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Blockchain {
    @SerializedName("blocks")
    private List<Block> blockchain;

    Blockchain(final List<Block> blockList) {
        this.blockchain = blockList;
    }

    List<Block> getBlockList() {
        return blockchain;
    }
}
