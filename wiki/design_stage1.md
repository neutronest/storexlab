# Detail Design (Stage 1)

## Introduction 

The Key-Value storage will be implemented into several steps. First we will implement a simple version, which will maintain the Key in memory, with the index of file location in disk. Also will involve basic log file compaction strategy. Later we will move to the formal LSM version, which using SSTable structure to capture the data.

## Stage 1

In Stage 1, we will mainly implement Get and Set features for a Key-Value data storage system.

## Basic Architecture

We will have k-v map table in memory, and a file to store the real value.

For in-memory table, the key is just the "key" we want, and the value here is the offset of file which we can index the value through this offset.

### Get
When trying to get value by key, system will retrieval the corresponding index location in target file, which the index is just stored with key. 

### Set

We'll follow append-only methodology that will only append new record in file rather than update old ones by random writing.
When a new k-v pair wait for setting:

* If the key doesn't exist in the memory table, then add key into memory, calculate how many offsets the value needed in disk, then append value into file (with key and delimiter if needed), and add (key, offset) pair into memory table.
* If the key has been existed in memory table, follow the same way to write new data into disk, and update the corresponding (key, offset) pair in memory.

## File format



The structure of in-memory table is straight forward, 
* Key: the real key for each (key, value) pair
* location info: include data offset and length (unit: byte)


while the format/protocol of value storage in disk can be different. Our design of file would be like:

* For the file type, we'll use **binary file** rather than plain txt file to save space.
* When a new (key, value) is to insert, We will first 
  * add key at the end of file, 
  * then followed with a k-v delimiter
  * then followed with value
  * then ended by a record delimiter


## Testing

### Unit tests

* Can insert key into memory and write value to right location of file
* Can read latest value from file in disk

### Integration tests

* TODO