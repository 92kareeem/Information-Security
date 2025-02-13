### **RSA Encryption & Decryption in Java**   Rivest-Shamir-Adleman
This program implements the **RSA algorithm**, a widely used public-key cryptosystem for secure data transmission. It generates two large prime numbers to compute the modulus (*N*) and derives the public and private keys. The encryption is performed using modular exponentiation with the public key, while decryption uses the private key.  

🔹 **Key Features:**  
- Generates **1024-bit RSA key pairs** (Public & Private).  
- Uses **modular exponentiation** for encryption & decryption.  
- Implements **key generation** using probable primes.  
- Ensures security by using **SecureRandom** for randomness.  

📌 **Use Cases:** Secure messaging, digital signatures, and cryptographic applications.  

---

### **MD5 Hashing in Java**  
This program computes the **MD5 hash** of a given string using Java’s `MessageDigest` class. MD5 (Message Digest Algorithm 5) is a cryptographic hash function that produces a fixed **128-bit hash** value (32-character hex format). Although MD5 is not recommended for cryptographic security due to vulnerabilities, it is still widely used for **checksums, integrity verification, and non-cryptographic hashing**.  

🔹 **Key Features:**  
- Uses **MessageDigest API** for efficient hashing.  
- Converts input into a **32-character hexadecimal hash**.  
- Suitable for **data integrity checks** and **hash-based indexing**.  

📌 **Use Cases:** File integrity verification, checksums, and fingerprinting data.  

---
