package utilities;
import java.io.IOException;
import java.security.GeneralSecurityException;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.security.GeneralSecurityException;
//import java.util.Properties;
//
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.search.SearchTerm;
//
//import com.sun.mail.util.MailSSLSocketFactory;
// 
///**
// * This program demonstrates how to search for e-mail messages which satisfy
// * a search criterion.
// * @author www.codejava.net
// *
// */
//public class mailCheck {
// 
//    /**
//     * Searches for e-mail messages containing the specified keyword in
//     * Subject field.
//     * @param host
//     * @param port
//     * @param userName
//     * @param password
//     * @param keyword
//     */
//    public void searchEmail(String host, String port, String userName,
//            String password, final String keyword) {
//        Properties properties = new Properties();
// 
//        // server setting
//        properties.put("mail.imap.host", host);
//        properties.put("mail.imap.port", port);
// 
//        // SSL setting
//        properties.setProperty("mail.imap.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.imap.socketFactory.fallback", "false");
//        properties.setProperty("mail.imap.socketFactory.port",
//                String.valueOf(port));
// 
//        Session session = Session.getDefaultInstance(properties);
// 
//        try {
//            // connects to the message store
//            Store store = session.getStore("imap");
//            store.connect(userName, password);
// 
//            // opens the inbox folder
//            Folder folderInbox = store.getFolder("INBOX");
//            folderInbox.open(Folder.READ_ONLY);
// 
//            // creates a search criterion
//            SearchTerm searchCondition = new SearchTerm() {
//                @Override
//                public boolean match(Message message) {
//                    try {
//                        if (message.getSubject().contains(keyword)) {
//                            return true;
//                        }
//                    } catch (MessagingException ex) {
//                        ex.printStackTrace();
//                    }
//                    return false;
//                }
//            };
// 
//            // performs search through the folder
//            Message[] foundMessages = folderInbox.search(searchCondition);
// 
//            for (int i = 0; i < foundMessages.length; i++) {
//                Message message = foundMessages[i];
//                String subject = message.getSubject();
//                System.out.println("Found message #" + i + ": " + subject);
//            }
// 
//            // disconnect
//            folderInbox.close(false);
//            store.close();
//        } catch (NoSuchProviderException ex) {
//            System.out.println("No provider.");
//            ex.printStackTrace();
//        } catch (MessagingException ex) {
//            System.out.println("Could not connect to the message store.");
//            ex.printStackTrace();
//        }
//    }
// 
//    /**
//     * Test this program with a Gmail's account
//     * @throws MessagingException 
//     * @throws GeneralSecurityException 
//     */
//    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
//    	
////    	try {
////    	Properties props =new Properties();
////    	  
////    	
////    	props.setProperty("mail.store.protocol", "pop3");
////    	MailSSLSocketFactory socketFactory= new MailSSLSocketFactory();
////    	socketFactory.setTrustAllHosts(true);
////    	props.put("mail.pop3s.ssl.socketFactory", socketFactory);
////
////    	props.put("mail.pop3.host", "pop.gmail.com");
////    	props.put("mail.pop3.port", "995");
////    	props.put("mail.pop3.starttls.enable", "true");
////        Session emailSession = Session.getDefaultInstance(props);
////    
////        //create the POP3 store object and connect with the pop server
////        Store store = emailSession.getStore("pop3s");
////
////        store.connect("pop.gmail.com", "midhubala1990@gmail.com", "Balamidhu@123");
////        Folder inbox = store.getFolder("Inbox");
////       
////		inbox.open(Folder.HOLDS_MESSAGES);
////		
////
////		// retrieve the messages from the folder in an array and print it
////		Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
////		System.out.println("messages.length---" + messages.length);
////
////		for (int i = 0, n = messages.length; i < n; i++) {
////			Message message = messages[i];
////			message.setFlag(Flag.SEEN, true);
////			System.out.println("---------------------------------");
////			System.out.println("Email Number " + (i + 1));
////			String Subject=message.getSubject();
////			System.out.println(Subject);
////			if(Subject.contains("Your Cartimize account has been created!"))
////			{
////				String content=message.getContent().toString();
////			System.out.println("Content :");
////			System.out.println("====================================================");
////			System.out.println(content);
////			i=n;
////			}
//////			System.out.println("Subject: " + message.getSubject());
//////			System.out.println("From: " + message.getFrom()[0]);
//////			System.out.println("Text: " + message.getContent().toString());
////
////		}
////
////		inbox.close(false);
////		store.close();
////
////	} catch (NoSuchProviderException e) {
////		e.printStackTrace();
////	} catch (MessagingException e) {
////		e.printStackTrace();
////	} catch (Exception e) {
////		e.printStackTrace();
////	}
//    	
//    	Properties props =new Properties();
//    	props.setProperty("mail.store.protocol", "imaps");
//    	
//    	Session session = Session.getInstance(props, null);
//    	MailSSLSocketFactory socketFactory= new MailSSLSocketFactory();
//    	socketFactory.setTrustAllHosts(true);
//    	props.put("mail.imaps.ssl.socketFactory", socketFactory);
//
//    	Store store = session.getStore("imaps");
//    	store.connect("imap.gmail.com", -1, "midhubala1990@gmail.com", "Balamidhu@123");
//
//    	Folder folder = store.getDefaultFolder();
//
//    	folder = folder.getFolder("Inbox");
//    	folder.open(Folder.READ_ONLY);   
//    	 BufferedReader reader = new BufferedReader(new InputStreamReader(
//    		      System.in));
//    	Message[] messages=folder.getMessages();
//    	System.out.println("message.length"+messages.length);
//    	   for (int i = 0; i < messages.length; i++) {
//               Message message = messages[i];
//               System.out.println("---------------------------------");
//               writePart(message);
//               String line = reader.readLine();
//               if ("YES".equals(line)) {
//                  message.writeTo(System.out);
//               } else if ("QUIT".equals(line)) {
//                  break;
//               }
//    	
//
//    	int totalMessages = folder.getMessageCount();
//    	int newMessages = folder.getNewMessageCount();
//    	System.out.println("Total messages = " + totalMessages);
//    	System.out.println("New messages = " + newMessages);
// 
// 
//}
//}
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.sun.mail.imap.IMAPStore;
import com.sun.mail.util.MailSSLSocketFactory;

public class FetchingEmail 
{
    static boolean done;

    public FetchingEmail()
    {
        this.done=false;
    }

  
    public static void main(String[] args) throws GeneralSecurityException
    {
        System.out.println("Hello from Connection Thread!");
        while(!done)
        {
            String host = "imap.gmail.com";// change accordingly
            String mailStoreType = "imap";
            String username = "midhubala1990@gmail.com";// change accordingly
            String password = "Balamidhu@123";// change accordingly

            receiveEmail(host, mailStoreType, username, password);

        }
    }

    public static void receiveEmail(String host, String storeType,  String username, String password) throws GeneralSecurityException
{
    try
    {
    	MailSSLSocketFactory sf = new MailSSLSocketFactory();
    	sf.setTrustAllHosts(true); 
    
        Properties properties = new Properties(); 
    	properties.put("mail.imaps.ssl.trust", "*");
    	properties.put("mail.imaps.ssl.socketFactory", sf);
        properties.put("mail.imaps.com", host);  
        properties.put("mail.imaps.starttls.enable","true");
        properties.put("mail.imaps.auth", "true");  // If you need to authenticate

        // Use the following if you need SSL
        properties.put("mail.imaps.socketFactory.port", 993);
        properties.put("mail.imaps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.imaps.socketFactory.fallback", "false");

        Session emailSession = Session.getDefaultInstance(properties);  
        emailSession.setDebug(true);

        //2) create the IMAP store object and connect with the Imap server  
        IMAPStore emailStore = (IMAPStore) emailSession.getStore(storeType);

        emailStore.connect(host, username, password);  

        //3) create the folder object and open it  
        Folder emailFolder = emailStore.getFolder("INBOX");  
        emailFolder.open(Folder.READ_ONLY);  

        //4) retrieve the messages from the folder in an array and print it  
        Message[] messages = emailFolder.getMessages();  
        for (int i = 0; i <messages.length; i++) 
        {
            Message message = messages[i];  
            MimeMessage m = new MimeMessage(emailSession);
            m.setContent(((MimeMessage)messages[i]).getContent() , "text/plain; charset=UTF-8");
            System.out.println("---------------------------------");  
            System.out.println("Email Number " + (i + 1));  
            System.out.println("Subject: " + message.getSubject());  
            System.out.println("From: " + message.getFrom()[0]);  
            System.out.println("Text: " + message.getContent().toString());  
            m.writeTo(System.out);
        }  

        //5) close the store and folder objects  
        emailFolder.close(false);  
        emailStore.close();  

    } 
    catch (NoSuchProviderException e) {e.printStackTrace();}   
    catch (MessagingException e) {e.printStackTrace();}  
    catch (IOException e) {e.printStackTrace();}

}

    public void stopThread()
    {
        this.done=true;
    }
}