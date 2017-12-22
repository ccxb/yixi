package weimakeji.sercice;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weimakeji.dao.HoutaiMapper;
import weimakeji.pojo.CustSourceTotal;
import weimakeji.pojo.Customer;
import weimakeji.pojo.LinkMan;
import weimakeji.pojo.PageBean;
import weimakeji.pojo.QueryVo;
import weimakeji.pojo.User;
import weimakeji.pojo.Visit;
import weimakeji.pojo.VisitList;



@Service
public class HoutaiServiceimple implements HoutaiService {
    
	@Autowired
	private HoutaiMapper houtaiMapper;
/**
 * ��¼У��
 */
	public User login(String username, String password) {
		User user =houtaiMapper.login(username, password);
		return user;
	}
/**
 * �޸�����
 */
public void updatePassword(String username, String newpass) {
  houtaiMapper.updatPassword(newpass,username);
	
}
public void addCustomer(Customer customer) {
	houtaiMapper.addCustomer(customer);
	
}
public List<Customer> findCustomer() {
	List<Customer> customer = houtaiMapper.findCustomer();
	return customer;
}
/*
 * ɾ���ͻ�
 * @see weimakeji.sercice.HoutaiService#delCustomer(java.lang.Long)
 */
public void delCustomer(Integer id) {
	houtaiMapper.delCustomer(id);
	
}
/**
 * �޸Ŀͻ���Ϣ֮��ѯ�ͻ�
 */
public Customer findCustomerById(Integer id) {
	Customer customer = houtaiMapper.findCustomerById(id);
	return customer;
}
/**
 * �޸Ŀͻ�
 */
public void updateCustomer(Customer customer) {
	houtaiMapper.updateCustomer(customer);
	
}
/**
 *ɸѡ�ͻ�
 */
//public List<Customer> customerScreen(String custName) {
//	Customer cust = houtaiMapper.customerScreen(custName);
//	return cust;
//}
//
public List<Customer> customerScreen(String custName) {
	List<Customer> cust = houtaiMapper.customerScreen(custName);
	return cust;
}

/**
 * ��ҳ�ķ���
 */
public PageBean listpage(Integer currentPage) {
	//����PageBean����
		PageBean pageBean = new PageBean();
		//��ǰҳ
		pageBean.setCurrentPage(currentPage);
		//�ܼ�¼��
		int totalCount = houtaiMapper.findCount();
		pageBean.setTotalCount(totalCount);
		//ÿҳ��ʾ��¼��
		int pageSize = 4;

		//z��ҳ��
		//�ܼ�¼�� ���� ÿҳ��ʾ��¼��
		//�ܹ�����
		int totalPage = 0;
		if(totalCount%pageSize==0) {//����
			totalPage = totalCount/pageSize;
		} else {
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//��ʼλ��
		int begin = (currentPage-1)*pageSize;
		//ÿҳ��¼��list����
		List<Customer> list = houtaiMapper.findPage(begin,pageSize);
		pageBean.setList(list);		
		
		return pageBean;
}
/**
 * �����ϵ��
 */
public void addLinkMan(LinkMan linkMan) {
	houtaiMapper.addLinkMan(linkMan);
	
}
public List<QueryVo> findLinkMan() {
	List<QueryVo> list = houtaiMapper.findLinkMan();
	return list;
}

/**
 * �޸���ϵ��֮�Ȳ�ѯ
 */
public QueryVo findLinkManById(Integer id) {
	QueryVo linkMan = houtaiMapper.findLinkManById(id);
	return linkMan;
}
/**
 * �޸���ϵ��
 */
public void updateLinkMan(QueryVo vo) {
	houtaiMapper.updateLinkMan(vo);
	
}
/**
 * ɸѡ��ϵ��
 */
public List<QueryVo> linkManScreen(String lkmName) {
	List<QueryVo> list =houtaiMapper.linkManScreen(lkmName);
	return list;
}
public List<User> findUser() {
	List<User> list = houtaiMapper.findUser(); 
	return list;
}

/**
 * ��Ӱݷ�
 */
public void addVisit(Visit visit) {
	houtaiMapper.addVisit(visit);
	
}
public List<VisitList> findVisit() {
	List<VisitList> list = houtaiMapper.findVisit();
	return list;
}
/**
 * ɾ���ݷü�¼
 */
public void delVisit(Integer id) {
	houtaiMapper.delVisit(id);
}
/**
 * ����id��ѯ�ݷü�¼
 */
public VisitList findVisitById(Integer id) {
	VisitList vi = houtaiMapper.findVisitById(id);
	return vi;
}
/**
 * �޸İݷü�¼
 */
public void updateVisit(VisitList visitList) {
	houtaiMapper.updateVisit(visitList);
	
}
public List<Customer> selectCustomer(Customer customer) {
	List<Customer> list = houtaiMapper.selectCustomer(customer);
	return list;
}
public List<QueryVo> selectLinkMan(QueryVo vo) {
	List<QueryVo> list = houtaiMapper.selectLinkMan(vo);
	return list;
}

/**
 * ��������ѯ�ݷü�¼
 */
public List<VisitList> selectVisit(VisitList visitList) {
	List<VisitList> list = houtaiMapper.selectVisit(visitList);
	return list;
}
public int findCountVip() {
	int count = houtaiMapper.findCountVip();
	return count;
}
public int findCountNewCustomer() {
	int count1 =houtaiMapper.findCountNewCustomer();
	return count1;
}
public int findCountQianZaiCustomer() {
  int count3 = houtaiMapper.findCountQianZaiCustomer();
	return count3;
}
public int findCountLoseCustomer() {
	int count4 = houtaiMapper.findCountLoseCustomer();
	return count4;
}

public List<CustSourceTotal> sourceTotals2() {
	List<CustSourceTotal> list= houtaiMapper.sourceTotals2();
	return list;
}
/**
 * 查询所有的用户User
 */
public List<User> findAllUser() {
  List<User> user =	houtaiMapper.findAllUser();
	return user;
}
/**
 * 根据id查询用户
 */
public User findUserById(Integer id) {
	User user = houtaiMapper.findUserById(id);
	return user;
}
/**
 * 修改用户
 */
public void updateUser(User user) {
	houtaiMapper.updateUser(user);
	
}

/**
 * 发送邮箱
 */
public void sendMail(String too, String text,String top) {
	 // 配置发送邮件的环境属性  
    final Properties props = new Properties();  
    // 表示SMTP发送邮件，需要进行身份验证  

    props.put("mail.smtp.host", "smtp.163.com");  
    // 发件人的账号  
    props.put("mail.user", "cxbcxbcxbcxb@163.com");  
    // 访问SMTP服务时需要提供的密码  
    props.put("mail.password", "cxb335477990");  
    props.put("mail.smtp.auth", "true");  

    // 构建授权信息，用于进行SMTP进行身份验证  
    Authenticator authenticator = new Authenticator() {  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() {  
            // 用户名、密码  
            String userName = props.getProperty("mail.user");  
            String password = props.getProperty("mail.password");  
            return new PasswordAuthentication(userName, password);  
        }  
    };  
    // 使用环境属性和授权信息，创建邮件会话  
    Session mailSession = Session.getInstance(props, authenticator);  
    // 创建邮件消息  
    MimeMessage message = new MimeMessage(mailSession);  
    // 设置发件人  
    InternetAddress form = null;
	try {
		form = new InternetAddress(  
		        props.getProperty("mail.user"));
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    try {
		message.setFrom(form);
	} catch (MessagingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  

    // 设置收件人  
    InternetAddress to = null;
	try {
		to = new InternetAddress(too);
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    try {
		message.setRecipient(RecipientType.TO, to);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    // 设置邮件标题  
    try {
		message.setSubject(top);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    // 设置邮件的内容体  
    try {
		message.setContent(text,"text/html;charset=UTF-8");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  

    // 发送邮件  
    try {
		Transport.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}

//删除联系人
public void deleteLinkMan(Integer id) {
	houtaiMapper.deleteLinkMan(id);
	
}
public List<Customer> findCustomerBiIds(Integer[] cid) {
	List<Customer>  customer = houtaiMapper.findCustomerByIds(cid);
	return customer;
}



public void sendMails(String to, String subject, String body, List<String> filepath) {
	 // 参数修饰  
    if (body == null) {  
        body = "";  
    }  
    if (subject == null) {  
        subject = "无主题";  
    }  
    // 创建Properties对象  
    Properties props = System.getProperties();  
    // 创建信件服务器  
    props.put("mail.smtp.host", "smtp.163.com");  
    props.put("mail.smtp.auth", "true"); // 通过验证  
    // 得到默认的对话对象  
    Session session = Session.getDefaultInstance(props, null);  
    // 创建一个消息，并初始化该消息的各项元素  
    MimeMessage msg = new MimeMessage(session);  
   String nick = null;
try {
	nick = MimeUtility.encodeText("测试admin");
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}  
    try {
		msg.setFrom(new InternetAddress(nick + "<" + "cxbcxbcxbcxb@163.com" + ">"));
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    // 创建收件人列表  
    if (to != null && to.trim().length() > 0) {  
        String[] arr = to.split(",");  
        int receiverCount = arr.length;  
        if (receiverCount > 0) {  
            InternetAddress[] address = new InternetAddress[receiverCount];  
            for (int i = 0; i < receiverCount; i++) {  
                try {
					address[i] = new InternetAddress(arr[i]);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            }  
            try {
				msg.addRecipients(Message.RecipientType.TO, address);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            try {
				msg.setSubject(subject);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            // 后面的BodyPart将加入到此处创建的Multipart中  
            Multipart mp = new MimeMultipart();  
            // 附件操作  
            if (filepath != null && filepath.size() > 0) {  
                for (String filename : filepath) {  
                    MimeBodyPart mbp = new MimeBodyPart();  
                    // 得到数据源  
                    FileDataSource fds = new FileDataSource(filename);  
                    // 得到附件本身并至入BodyPart  
                    try {
						mbp.setDataHandler(new DataHandler(fds));
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
                    // 得到文件名同样至入BodyPart  
                    try {
						mbp.setFileName(fds.getName());
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
                    try {
						mp.addBodyPart(mbp);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
                }  
                MimeBodyPart mbp = new MimeBodyPart();  
                try {
					mbp.setText(body);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                try {
					mp.addBodyPart(mbp);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                // 移走集合中的所有元素  
                filepath.clear();  
                // Multipart加入到信件  
                try {
					msg.setContent(mp);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            } else {  
                // 设置邮件正文  
                try {
					msg.setText(body);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            }  
            // 设置信件头的发送日期  
            try {
				msg.setSentDate(new Date());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            try {
				msg.saveChanges();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            // 发送信件  
            Transport transport = null;
			try {
				transport = session.getTransport("smtp");
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            try {
				transport.connect("smtp.163.com", "cxbcxbcxbcxb@163.com", "cxb335477990");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            try {
				transport.sendMessage(msg,  
				        msg.getRecipients(Message.RecipientType.TO));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            try {
				transport.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            return;  
        } else {  
            System.out.println("None receiver!");  
            return;  
        }  
    } else {  
        System.out.println("None receiver!");  
        return;  
    }  
}

/**
 * 查询前五条记录
 */
public List<Customer> findCustomerLimit() {
	List<Customer> cust = houtaiMapper.findCustomerLimit();
	return cust;
}

/**
 * 查询联系人前五条记录
 */
public List<QueryVo> findLinkManLimit() {
	List<QueryVo> list = houtaiMapper.findLinkManLimit();
	return list;
}

/**
 * 查询拜访记录前五条记录
 */
public List<VisitList> findVisitLimit() {
	List<VisitList> vi = houtaiMapper.findVisitLimit();
	return vi;
}  

	
}








 
	



	

	
	




