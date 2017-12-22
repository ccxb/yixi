package weimakeji.sercice;


import java.util.List;

import weimakeji.pojo.CustSourceTotal;
import weimakeji.pojo.Customer;
import weimakeji.pojo.LinkMan;
import weimakeji.pojo.PageBean;
import weimakeji.pojo.QueryVo;
import weimakeji.pojo.User;
import weimakeji.pojo.Visit;
import weimakeji.pojo.VisitList;



public interface HoutaiService {

	User login(String username, String password);

	void updatePassword(String username, String newpass);

	void addCustomer(Customer customer);

	List<Customer> findCustomer();

	void delCustomer(Integer id);

	
	
   Customer findCustomerById(Integer id);

void updateCustomer(Customer customer);

List<Customer> customerScreen(String custName);

PageBean listpage(Integer currentPage);

void addLinkMan(LinkMan linkMan);

List<QueryVo> findLinkMan();

QueryVo findLinkManById(Integer id);

void updateLinkMan(QueryVo vo);

List<QueryVo> linkManScreen(String lkmName);

List<User> findUser();

void addVisit(Visit visit);

List<VisitList> findVisit();

void delVisit(Integer id);

VisitList findVisitById(Integer id);

void updateVisit(VisitList visitList);

List<Customer> selectCustomer(Customer customer);

List<QueryVo> selectLinkMan(QueryVo vo);

List<VisitList> selectVisit(VisitList visitList);

int findCountVip();

int findCountNewCustomer();



int findCountQianZaiCustomer();

int findCountLoseCustomer();



List<CustSourceTotal> sourceTotals2();

List<User> findAllUser();

User findUserById(Integer id);

void updateUser(User user);

void sendMail(String too, String text,String top);

void deleteLinkMan(Integer id);

List<Customer> findCustomerBiIds(Integer[] cid);

void sendMails(String to, String subject, String body, List<String> filepath);

List<Customer> findCustomerLimit();

List<QueryVo> findLinkManLimit();

List<VisitList> findVisitLimit();



//List<CustSourceTotal> findCount(List<CustSourceTotal> list);









 
	




	

	
	

	
	
}
