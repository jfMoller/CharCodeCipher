## About this project:
My first small Java project. I wanted to build an encryption/decryption cipher
using Unicode to become more familiar with the language.

## How it works:
Encryption is performed by adding a random encryption key to the original decimal Unicode value (DCV) of characters.
For example, the character 'A' has a DCV of 65. If an encryption key with the value 589 is added, the result is 65 + 589 = 654.
The new value is then type-casted as char: (char) 654 -> 'ʎ'.

## Example:

