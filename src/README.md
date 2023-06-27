## About this project:
My first small Java project. I wanted to build an encryption/decryption cipher
using Unicode to become more familiar with the language.

## How it works:
Encryption is performed by adding a random encryption key to the original decimal Unicode value (DCV) of characters.
For example, the character 'A' has a DCV of 65. If an encryption key with the value 589 is added, the result is 65 + 589 = 654.
The new value is then type-casted as char: (char) 654 -> 'ʎ'.

## Example:
#### 1. Enter the text that you want to encrypt:
Text:
```
Each character of this text will have its Unicode scrambled!
```
#### Encryption result:
Encrypted text:
```
ýŎƲ˫ƫ͒ßſ̻ΓâɂʙʃĐǳϏȿ̛
```

Encryption keys:
```
176237327646395741122351710805112477568543175401867474762
```
#### 2. Enter the text you want to decrypt, then enter the keys
Encrypted text:
```
̗ĩʮČĉûʺȱΧαȽ΀˺Ȏʹń̑
```
Encryption keys:
```
718182654152161146583529821844476796665428776223722
```
#### Decryption result:
Text:
```
Is this readable?
```