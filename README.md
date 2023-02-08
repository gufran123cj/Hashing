# Introduction

- Object Oriented Principles (OOP) and try-catch exception handling must be used when it is needed.
- Hash function for converting a word to a key must be implemented by yourself. The value will be the word and the key will be returned by your hash function. The number of occurrences of each word also must be stored as count value. 
- The hash code for converting a key to the bit representation must be implemented by yourself.
- The initial table should index a given key according to the last 8 bits (initial global depth and local depths will be 8). Every slot of the table points a bucket. The bucket size is 10.
- When you need to resize the hash table, the new table size must be doubled to index words by using one more bit (global depth+1). The bucket size won’t change. E.g., After the first resize operation, the table should index according to the last 9 bits. After the second resize, it should index according to 10 bits etc.
- When a word is searched in the hash table; key, count, and index of the word should be printed. (Global and local depths should also be printed)

# The Hash table should look like as below:
![image](https://user-images.githubusercontent.com/74301873/217533590-c2aedf52-4282-4266-af23-df18b2819212.png)

# A HASHING ALGORITHM

Assume that the hash code function hc(key) returns a string of bits. The last i bits of each string will be used as indices to figure out where they will go in the "directory" (hash table). Additionally, i is the smallest number such that the index of every item in the table is unique.
Example keys:
      hc(key1) = 001001
      hc(key2) = 011010
      hc(key3) = 011011
Let's assume that for this example, the bucket size is 1. Key1 and Key2 can be distinguished by their last bit; they will be inserted into the table as follows:
![image](https://user-images.githubusercontent.com/74301873/217533889-7eb9fcc3-c974-48fb-bf17-71e898e6c6fe.png)

Note: A and B are only names of buckets. For next examples C, D, and E will be also bucket names. You don’t have to put a name to a bucket in your codes.

When key3 is to be hashed to the table, it wouldn't be enough to distinguish all three keys by using only their last bit (because both key3 and key1 have 1 as their rightmost bit). Furthermore, due to the bucket size being one, the table would overflow. Comparison of two less significant bits (rightmost bits) would give each key a unique index in the table, and the directory size is doubled as follows:

![image](https://user-images.githubusercontent.com/74301873/217535013-6df0621b-8b7e-46c9-a6bb-7314c233c4e9.png)

Key1 and Key3 have a unique location, being distinguished by the first two rightmost bits. Key2 is pointed by both 00 and 10, because there is no other key in the table which ends with a 0.

To insert key4 into the table, first compute the hash function as below:
         hc(key4) = 011110
         
 
Key4 needs to be inserted in the table, hash function returns the last two bits as 10. Using a 2 bits depth in the directory, key4 will map to index 10 and corresponding to the Bucket A. Bucket A is already full (due to max size =1), so it must be splitted. Because there is more than one pointer to the Bucket A, there is no need to increase the directory size. To perform such operations, some rules are defined:
-The hash function returns binary representation of a given key (bk). The last N bits of bk shows the directory (table) size (i.e., the global depth).
-The previously used the global depth value of a bucket is created shows the local depth of this bucket.
-The number of directory entries is equal to 2^global depth, and the initial number of buckets is equal to 2^local depth

![image](https://user-images.githubusercontent.com/74301873/217535298-bf0feccc-025e-44cd-af70-01e15b95cf0e.png)

When a bucket becomes full:
a) If (global depth - local depth) = 0, then 2^0 = 1, one pointer shows to one bucket. The directory size will be doubled.
b) If (global depth - local depth) > 0, a new bucket will be created, and the entries in the old bucket will re-distributed between the old and new bucket.


