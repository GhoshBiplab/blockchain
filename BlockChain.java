package com.biplab.bloackchain;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    public static void main(String[] args) {


        List<Block> chain = new ArrayList<>();

        Block genesis = new Block("GenesisBlock", "0");
        chain.add(genesis);

        Block block1 = new Block("This is Block1", chain.get(chain.size() - 1).getHash());
        chain.add(block1);
        Block block2 = new Block("This is Block2", chain.get(chain.size() - 1).getHash());
        chain.add(block2);
        Block block3 = new Block("This is Block3", chain.get(chain.size() - 1).getHash());
        chain.add(block3);
        System.out.println("-------------------::BlockChain::--------------------------");
        chain.forEach(System.out::println);
        System.out.println("Is valid: " + isChainValid(chain));


        // corrupt block chain::One of the Block has been modified
        Block newBlock = new Block("NewBlock", genesis.getHash());
        int index = chain.indexOf(block1);
        chain.remove(index);
        chain.add(index, newBlock);
        System.out.println("-------------------::BlockChain::--------------------------");
        System.out.println("Computed the  block chain again by replacing Block1 with a newBlock");
        chain.forEach(System.out::println);
        System.out.println("Is valid: " + isChainValid(chain));

    }

    public static Boolean isChainValid(List<Block> chain) {

        //Traverse the  blockchain to check hashes
        for (int i = chain.size() - 1; i > 0; i--) {

            if (!chain.get(i).getHash().equals(chain.get(i).computeHash())) {
                System.out.println("Registered Hashes and computed hashes are not equal");
                return false;
            }
            if (!chain.get(i - 1).getHash().equals(chain.get(i).getPreviousHash())) {
                System.out.println("Previous Hashes  and Current Hashes are not equal");
                return false;
            }

        }
        return true;
    }
}
