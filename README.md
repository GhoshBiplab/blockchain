## Concept of BlockChain with Java

In this article we will understand the basic concept of Blockchain and will build a simple Blockchain using java.

The concept is very simple but  very powerful. Each block in the chain stores the hash of the previous block and its own hash.

If the data of previous block’s changed then the previous block’s hash will also change ( since data  is also part of hash calculation) in turn affecting all the hashes of the blocks thereafter. This ensures a block cannot be modified without modifying all the following blocks. Comparing  the hashes it is very easy to find if a blockchain is invalid.

33 What is Block?

It can be divided in two  section  Header & Data.



According to Bitcoin Book, a block is a container data structure that clusters transactions for incorporation in the public ledger.


## Let’s create the  BlockChain

A blockchain is list of blocks . Each block in the blockchain will have its own hash, contain digital hash of the previous block and  data.


Two files Block and BlockChain has been crtaeted which will be helpful to understand the concept.

You can access the full article in the below link
https://bipslab.blogspot.com/

