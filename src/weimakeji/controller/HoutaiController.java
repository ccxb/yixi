package weimakeji.controller;


import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import weimakeji.pojo.CustSourceTotal;
import weimakeji.pojo.Customer;
import weimakeji.pojo.Email;
import weimakeji.pojo.LinkMan;
import weimakeji.pojo.PageBean;
import weimakeji.pojo.QueryVo;
import weimakeji.pojo.User;
import weimakeji.pojo.Visit;
import weimakeji.pojo.VisitList;
import weimakeji.sercice.HoutaiService;

@Controller
@RequestMapping("/crm")
public class HoutaiController {
	@Autowired
	private HoutaiService houtaiService;	

  //用户登录界面
  @RequestMapping("/login")
 public String manage() throws Exception{
	 
	 return "/login";
	 
 }
  
  @RequestMapping("/test")
  public String test()  throws Exception{
	  return "test";
  }
  
  /**
   * 用户登录校验
   * @return
   * @throws Exception
   */
  @RequestMapping("/index")
  
  public String index(User user,Model model,HttpServletRequest req) throws Exception{
    user =  houtaiService.login(user.getUsername(),user.getPassword());
    
    if(user!=null) {
    	//model.addAttribute("User",user);
       req.getSession().setAttribute("User", user);
    	return "/index";
    }
	 model.addAttribute("msg","用户名或密码错误");
	 
	 return "login";
  }
  /**
   * 修改密码
   * @param model
   * @param user
   * @return
   * @throws Exception
   */
  @RequestMapping("/updatepwd")
  public String updatepwd(Model model, User user,HttpServletRequest req) throws Exception{
	//从session中查询use
	  User use = (User)req.getSession().getAttribute("User");   
     User user1 = houtaiService.login(use.getUsername(),user.getPassword());
     if(user1!=null) { 	
   	 houtaiService.updatePassword(user1.getUsername(),user.getNewpass());
    	 return "login";
     }else {
    	 model.addAttribute("msg","原密码错误");    	 
    	 return "/xiugai";
     }
  }
  /*
   * 添加客户信息
   */
  @RequestMapping("/addCustomer")
  public String addCustomer(Customer customer,Model model) throws Exception{
	  houtaiService.addCustomer(customer);
	  List<Customer> cust = houtaiService.findCustomerLimit();
	  model.addAttribute("customer",cust);
	  return "/success";
  }
  
  /*
   * 客户列表
   */
  @RequestMapping("/custList")
 public String custList(Model model) throws Exception{
	
	List<Customer> customer = houtaiService.findCustomer();
	model.addAttribute("customer",customer);
	 return "/custList";
 }
  
  /**
   * 分页查询所有客户
   * @param id
   * @return
   * @throws Exception
   */
  
	//使用属性封装获取
//	private Integer currentPage;
//	public Integer getCurrentPage() {
//		return currentPage;
//	}
//
//	public void setCurrentPage(Integer currentPage) {
//		this.currentPage = currentPage;
//	}
  
  @RequestMapping("/findCustomerByPage")
  public String findCustomerByPage(Model model , PageBean pageBean) throws Exception{
	   //调用service方法实现封装
	   pageBean = houtaiService.listpage(pageBean.getCurrentPage());
	   model.addAttribute("pageBean",pageBean);
	  return "/listpage";
  }
  
  @RequestMapping("/findCustomerBypages/{id}")
  public String findCustomerByPage1(@PathVariable("id") Integer id,Model model , PageBean pageBean) throws Exception{
	 
	  //调用service方法实现封装
	  pageBean.setCurrentPage(id);
	   pageBean = houtaiService.listpage(pageBean.getCurrentPage());
	   model.addAttribute("pageBean",pageBean);
	  return "/listpage";
	
  }
  /*
   * 删除客户
   */
  @RequestMapping("/delCustomer/{id}")
  public ModelAndView delCustomer(@PathVariable("id") Integer id) throws Exception{
	   houtaiService.delCustomer(id);
	  return new ModelAndView("redirect:/spring/crm/custList");
  }
  
  /*
   * 修改客户之按id查询客户
   */
  @RequestMapping("/findCustomerById/{id}")
  public String findCustomerById(@PathVariable("id") Integer id,Model model) throws Exception{
	  Customer customer = houtaiService.findCustomerById(id);
   model.addAttribute("customer",customer);
	  return "/edit";
  }
  /**
   * 修改客户
   */
  @RequestMapping("/updateCustomer")
  public String updateCustomer(Customer customer) throws Exception{
	   houtaiService.updateCustomer(customer);
	  return "/success";
  }
  
  /**
   * 筛选客户
   */
  
  @RequestMapping("/customerScreen")
  public String customerScreen(Customer customer,Model model) throws Exception{
	String custName =  customer.getCustName();
	List<Customer> cust =  houtaiService.customerScreen(custName);
	  model.addAttribute("customer",cust);
	  return "/custList";
  }
  
  /**
   * 添加联系人页面
   */
  @RequestMapping("/addLinkManPage")
  public String addLinkManPage(HttpServletRequest req) throws Exception {
	  List<Customer> customer = houtaiService.findCustomer();
	  req.getSession().setAttribute("listCustomer", customer);
	  return "/jsp/linkman/add";
  }
  
  /**
   * 添加联系人
   * @param linkMan
   * @param customer
   * @return
   * @throws Exception
   */
  @RequestMapping("/addLinkMan")
  public String addLinkMan(LinkMan linkMan,Customer customer,Model model) throws Exception {
	  
 linkMan.setClid(customer.getCid());
	   houtaiService.addLinkMan(linkMan);
	   List<QueryVo> list = houtaiService.findLinkManLimit();
		model.addAttribute("list",list);
	  return "/jsp/linkman/success";
  }
  
  /**
   * 联系人列表
   */
  
  @RequestMapping("/linkManList")
 public String linkManList(Model model) throws Exception{
	List<QueryVo> list = houtaiService.findLinkMan();
	model.addAttribute("list",list);
	 return "/jsp/linkman/list";
 }
  
  /**
   * 修改联系人之按id查询联系人
   * @return
   * @throws Exception
   */
  @RequestMapping("/findLinkManById/{id}")
  public String findLinkManById(@PathVariable("id") Integer id,Model model) throws Exception {
	 QueryVo linkMan = houtaiService.findLinkManById(id);
	 
	 model.addAttribute("linkman",linkMan);
	 List<Customer> customer = houtaiService.findCustomer();
	 model.addAttribute("customer",customer);
	
	  return "/jsp/linkman/edit";
  }
  
  /**
   * 修改联系人
   */
  @RequestMapping("/updateLinkMan")
  public String updateLinkMan(QueryVo vo) throws Exception{
	  houtaiService.updateLinkMan(vo);
	  return "/success";
  }
  /**
   * 删除联系人
   * @param id
   * @return
   * @throws Exception
   */
  @RequestMapping("/deleteLinkMan/{id}")
  public String deleteLinkMan(@PathVariable("id") Integer id) throws Exception{
	  houtaiService.deleteLinkMan(id);
	  return "/success";
  }
  /**
   * 筛选联系人
   */
  @RequestMapping("/linkManScreen")
  public String linkManScreen(LinkMan linkman,Model model) throws Exception{
	  String lkmName =  linkman.getLkmName();
	List<QueryVo> list= houtaiService.linkManScreen(lkmName);
	model.addAttribute("list",list);
	  return "/jsp/linkman/list";
  }
  
  /**
   * 添加拜访页面
   * @return
   * @throws Exception
   */
  @RequestMapping("/addVisitPage")
  public String addVisitPage(Model model) throws Exception{
	List<User> list =  houtaiService.findUser();
	List<Customer> customer =houtaiService.findCustomer();
	model.addAttribute("listCustomer",customer);
	model.addAttribute("list",list);
	  return "/jsp/visit/add";
  }
  
  /**
   * 添加拜访
   */
  @RequestMapping("/addVisit")
  public String addList(Visit visit,Model model) throws Exception{
	  houtaiService.addVisit(visit);
	 
	  List<VisitList> li = houtaiService.findVisitLimit();
	  model.addAttribute("list",li);
	  return "/jsp/visit/success";
  }
  
  /**
   * 拜访列表
   */
  @RequestMapping("/visitList")
  public String visitList(Model model) throws Exception {
	  List<VisitList> list = houtaiService.findVisit();
	  model.addAttribute("list",list);
	  return "/jsp/visit/list";
  }
  
  /**
   * 删除拜访记录
   */
  @RequestMapping("/delVisit/{id}")
  public ModelAndView delVisit(@PathVariable("id") Integer id) throws Exception {
	  houtaiService.delVisit(id);
	  return new ModelAndView("redirect:/spring/crm/visitList");
  }
  /**
   * 根据id查询拜访记录
   */
  
  @RequestMapping("/findVisitById/{id}")
  public String findVisitById(@PathVariable("id") Integer id ,Model model) throws Exception {
	VisitList visit = houtaiService.findVisitById(id);	
	  
	List<User> user =  houtaiService.findUser();
	List<Customer> customer =houtaiService.findCustomer();
	model.addAttribute("visit",visit);	
	model.addAttribute("user",user);
	model.addAttribute("customer",customer);
	  return "/jsp/visit/edit";
  }
  /**
   * 修改拜访记录
   */
  @RequestMapping("/updateVisit")
  public String updateVisit(VisitList visitList) throws Exception{
	   houtaiService.updateVisit(visitList);
	  return "/success";
  }
  /**
   * 客户信息查询
   */
  @RequestMapping("/selectCustomer")
  public String selectCustomer(Customer customer,Model model) throws Exception{
	 List<Customer> list = houtaiService.selectCustomer(customer);
	 model.addAttribute("customer",list);
	  return "/custList";
  }
  
  /**
   * 多条件查询联系人
   */
  @RequestMapping("/selectLinkmanPage")
  public String selectLinkman(Model model) throws Exception{
	  List<Customer> list = houtaiService.findCustomer();
	  model.addAttribute("list",list);
	  return "/jsp/selet/linkman";
  }
  
  @RequestMapping("/selectLinkMan")
  public String selectLinkMan(QueryVo vo,Model model) throws Exception{
	 List<QueryVo> list = houtaiService.selectLinkMan(vo);
	 model.addAttribute("list",list);
	 return "/jsp/linkman/list";
  }
  
  @RequestMapping("/selectVisitPage")
  public String selectVisitPage(Model model) throws Exception{
	  List<User> list =houtaiService.findUser();
	  List<Customer> customer = houtaiService.findCustomer();
	   model.addAttribute("list",list);
	   model.addAttribute("listCustomer",customer);
	  return "/jsp/selet/visit";
  }
  /**
   * 多条件查询拜访记录
   * @param visitList
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping("/selectVisit")
  public String selectVisit(VisitList visitList,Model model) throws Exception{
	List<VisitList> list = houtaiService.selectVisit(visitList);
	model.addAttribute("list",list);
	  return "/jsp/visit/list";
  }
  
  /**
   * 统计分析
   */
  @RequestMapping("/totals")
  public String totals(Model model) throws Exception {
    int count = houtaiService.findCountVip();
    int count1 = houtaiService.findCountNewCustomer();
    int count3 = houtaiService.findCountQianZaiCustomer();
    int count4 = houtaiService.findCountLoseCustomer();
    model.addAttribute("count",count);
    model.addAttribute("count1",count1);
    model.addAttribute("count3",count3);
    model.addAttribute("count4",count4);
	  return "/jsp/totals/level";
  }
  
  /**
   * 客户来源统计
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping("/sourceTotals2")
  public String sourceTotals2(Model model) throws Exception{ 	
	  List<CustSourceTotal> list = houtaiService.sourceTotals2(); 
	  model.addAttribute("list",list);
	  return "/jsp/totals/source2";
  }
   
  /**
   *  查询所有的用户User
   */
  @RequestMapping("/findAllUser")
   public String findAllUser(Model model) throws Exception{
	 List<User> user =  houtaiService.findAllUser();
	 model.addAttribute("user",user);
	   return "/jsp/admin/source";
   }
  
  /**
   * 根据id查询客户
   */
  @RequestMapping("/findUserById/{id}")
  public String findUserById(@PathVariable("id") Integer id , Model model) throws Exception{
	   User user = houtaiService.findUserById(id);
	   model.addAttribute("user",user);
	  return "/jsp/admin/edit";
  }
  
  /**
   * 修改用户
   */
  @RequestMapping("/updateUser")
  public String updateUser(User user) throws Exception{
	  houtaiService.updateUser(user);
	  return "/success";
  }
  
/**
 * 到发送邮箱页面
 */
  @RequestMapping("/sendMailPage/{id}")
  public String sendMailPage(@PathVariable("id") Integer id,Model model) throws Exception{
	  Customer customer = houtaiService.findCustomerById(id);
	  model.addAttribute("customer",customer);
	  return "/sendEmail";
  }
  
  /**
   * 发送邮箱
   */
  @RequestMapping("/sendEmail")
  public String sendEmail(Email email) {
	  String too = email.getCustEmail();
    String text = email.getText();
    String top = email.getTop();
    houtaiService.sendMail(too,text,top);
	  return "/success";
  }
  /**
   * 
   */
  @RequestMapping("/findCustomerBiIds")
  public String findCustomerBiIds(Integer[] cid,Model model)throws Exception{
	List<Customer> customer = houtaiService.findCustomerBiIds(cid);
	model.addAttribute("list",customer);
	  
	 return "/jsp/email/sendEmail";
  }
  
  /**
   * 批量发送邮箱
   * @return
   * @throws Exception
   */
  @RequestMapping("/sendMails")
  public String sendMails(Email email) throws Exception{
	 String to= email.getCustEmail();
	 String body=email.getText();
	 String subject=email.getTop();
	 List <String> filepath = null;
	 houtaiService.sendMails(to,subject,body,filepath);
	  return "/success";
  }
}

