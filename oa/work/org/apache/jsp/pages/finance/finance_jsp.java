package org.apache.jsp.pages.finance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class finance_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/commons/taglibs.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>网站后台管理</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/main.css\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form method=\"post\" action=\"user-add.action\">\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"where\">\r\n");
      out.write("            <ul>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("      <div class=\"sort_switch\">\r\n");
      out.write("          <ul id=\"TabsNav\">\r\n");
      out.write("          \t  <li class=\"selected\"><a href=\"#\">填写请假申请</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      <div id=\"tagContent0\" class=\"sort_content\">\r\n");
      out.write("        \t  \r\n");
      out.write("        \t<div class=\"currency_area hue9\">\r\n");
      out.write("            \t<div class=\"the_content\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                \t<table class=\"tableHue2\" width=\"100%\" border=\"1\" bordercolor=\"#dddddd\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                      <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">开始日期：</td>\r\n");
      out.write("                          <td class=\"left\"><input name=\"userForm.lastName\" type=\"text\" class=\"input_text2\" size=\"30\" /></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">结束日期：</td>\r\n");
      out.write("                          <td class=\"left\"><input name=\"userForm.passwd\" type=\"text\" class=\"input_text2\" size=\"30\" /></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">请假天数：</td>\r\n");
      out.write("                          <td class=\"left\"><input name=\"userForm.passwd\" type=\"text\" class=\"input_text2\" size=\"30\" /></td>\r\n");
      out.write("\t\t\t\t\t\t  </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">休假类型：</td>\r\n");
      out.write("                          <td class=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"userForm.groupId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"1\">年假</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2\">事假</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"3\">病假</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t  </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">原因：</td>\r\n");
      out.write("                          \t<td class=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea cols=\"33\" rows=\"5\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                      </tbody>\r\n");
      out.write("                  </table>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"fun_area\" style=\"text-align:center;\"><input type=\"submit\" value=\"确 定\" class=\"input_button1\"/></div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    _jspx_th_c_005fset_005f0.setVar("ctx");
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
