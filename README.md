# Simple Java File Server

This is a simple file-sharing server written in Java. It allows you to:
- Download files from your PC to your phone.
- Upload files from your phone to your PC.
- Access files over Wi-Fi using a web browser.

## 🚀 Features
✅ Download files from PC to phone.
✅ Upload files from phone to PC.
✅ Works over Wi-Fi (no internet required).
✅ No extra apps needed—just use a browser.

---

## 📥 How to Set Up the Server

### 1️⃣ Prerequisites
- Java Development Kit (JDK) installed (version 8 or higher)
- A PC and phone connected to the **same Wi-Fi network**

### 2️⃣ How to Run the Server
1. **Compile the Java program:**
   ```sh
   javac FileSharingServer.java
   ```
2. **Run the server:**
   ```sh
   java FileSharingServer
   ```
3. **Find Your PC’s Local IP:**
   - **Windows:** Open Command Prompt and run:
     ```sh
     ipconfig
     ```
   - **Mac/Linux:** Open Terminal and run:
     ```sh
     ifconfig
     ```
   - Look for the `IPv4 Address` (e.g., `192.168.1.100`).

---

## 📂 File Save Location
By default, uploaded files are saved in:
```
C:/Users/veesh
```

### **Change the Save Location**
To change the folder where files are stored, edit this line in `FileSharingServer.java`:
```java
private static final String DIRECTORY = "C://Users//veesh"; // Change this to your desired folder
```
Example for saving files to Desktop:
```java
private static final String DIRECTORY = "C:/Users/YourUsername/Desktop/SharedFiles";
```

---

## 📱 How to Access the Server from Your Phone
1. Open a **browser on your phone**.
2. Type in your PC’s IP address and port, for example:
   ```
   http://192.168.1.100:8000/
   ```
3. You can now **download** or **upload** files!

---

## ❓ Troubleshooting
### **1. Cannot Access from Phone**
- Ensure **both devices are on the same Wi-Fi network**.
- Disable any **firewall** or allow Java in your firewall settings.

### **2. File Not Saving in Expected Location**
- Ensure the folder path in `DIRECTORY` exists.
- Run the server with administrator privileges.

---

## 🎯 Future Enhancements
- 🔐 **Password Protection**
- 🎨 **Better UI with file previews**
- 📂 **Multiple folder selection**

---

### **📧 Need Help?**
If you have any issues, feel free to ask for support!

Happy file sharing! 🚀

