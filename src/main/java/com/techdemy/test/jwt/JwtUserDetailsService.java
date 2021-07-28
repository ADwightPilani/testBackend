package com.techdemy.test.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techdemy.test.entity.*;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	User1Repository userrepo;
   
	@Autowired
	User1Repository userrepo2;	
	@Autowired
	
	private PasswordEncoder bcryptEncoder;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
	       
        User1 user = new User1() ;
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
       
         
        return authorities;
    }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User1 user = userrepo2.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	//non dto code below	//return new org.springframework.security.core.userdetails.User(user.getname(), user.getpassword(),
			//	new ArrayList<>());
		return new Userdetails1(user);//you have to implement userdetails if you dont want to use dto
	}

// implement without dto	public com.stockexchange.phase3.User1 save(UserDto user) {
	public User1 save(User1 user) {
		User1 newUser = new User1();
		//newUser.setname(user.getUsername());
		//newUser.setpassword(bcryptEncoder.encode(user.getPassword()));
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    newUser.setEmail(user.getEmail());
		newUser.setRole(user.getRole());
		User1 saved= userrepo.save(newUser);
		try {
			sendemail(saved.getId()) ;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saved;
		
	}
	
	public void sendemail(Long userid) throws AddressException, MessagingException {

	      User1 user = userrepo.getById(userid);	

			final String username = "hibernatevalidation@gmail.com";
			final String password = "springboot";

			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true"); //TLS

			Session session = Session.getInstance(prop,
					new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("hibernatevalidation@gmail.com"));
				//message.setRecipients(
					//	Message.RecipientType.TO,
					//	InternetAddress.parse("sftrainerram@gmail.com")
					//	);
				message.setRecipients(
						Message.RecipientType.TO,
						InternetAddress.parse(user.getEmail())
						);
				message.setSubject("User confirmation email");
				//     message.setText("Dear Mail Crawler,"
				//           + "\n\n Please do not spam my email!");
				message.setContent(
						"<h1><a href =\"http://127.0.0.1:8080/confirmuser/"+userid+"/\"> Click to confirm </a></h1>",
						"text/html");
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}





	}