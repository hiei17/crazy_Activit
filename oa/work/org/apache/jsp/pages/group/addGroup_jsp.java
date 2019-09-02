package org.apache.jsp.pages.group;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class addGroup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/main.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/turn_page1.css\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form method=\"post\" id=\"addForm\">\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("    \t\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"where\">\r\n");
      out.write("            <ul>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("      <div class=\"sort_switch\">\r\n");
      out.write("          <ul id=\"TabsNav\">\r\n");
      out.write("          \t  <li class=\"selected\"><a href=\"javascript:void(0)\" onClick=\"selectTag('tagContent0',this)\">添加用户组</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      <div id=\"tagContent0\" class=\"sort_content\">\r\n");
      out.write("        \t  \r\n");
      out.write("        \t<div class=\"currency_area hue9\">\r\n");
      out.write("          \t\t<div class=\"the_title T10\">\r\n");
      out.write("            \t\t<h5><strong>用户组</strong></h5>\r\n");
      out.write("            \t</div>\r\n");
      out.write("            \t<div class=\"the_content\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                \t<table class=\"tableHue2\" width=\"100%\" border=\"1\" bordercolor=\"#dddddd\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                      <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">班别名称：</td>\r\n");
      out.write("                          <td class=\"left\"><input name=\"className\" id=\"className\" type=\"text\" class=\"input_text2\" size=\"30\" /></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">内容链接：</td>\r\n");
      out.write("                          <td class=\"left\"><input name=\"contentLink\" type=\"text\" class=\"input_text2\" size=\"60\" /></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">简单描述：</td>\r\n");
      out.write("                          <td class=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t\tvar oFCKeditor2 = new FCKeditor('simpleContent');\r\n");
      out.write("\t\t\t\t\t\t\toFCKeditor2.BasePath = \"/fckeditor/\";\r\n");
      out.write("\t\t\t\t\t\t\toFCKeditor2.Height = 200;\r\n");
      out.write("\t\t\t\t\t\t\toFCKeditor2.Create();\r\n");
      out.write("\t\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t\t  </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                          <td width=\"15%\" class=\"title1\">班别内容：</td>\r\n");
      out.write("                          <td class=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t\tvar oFCKeditor = new FCKeditor('classContent');\r\n");
      out.write("\t\t\t\t\t\t\toFCKeditor.BasePath = \"/fckeditor/\";\r\n");
      out.write("\t\t\t\t\t\t\toFCKeditor.Height = 600;\r\n");
      out.write("\t\t\t\t\t\t\toFCKeditor.Create();\r\n");
      out.write("\t\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t\t  </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                      </tbody>\r\n");
      out.write("                  </table>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("                        \r\n");
      out.write("            \r\n");
      out.write("            <div class=\"fun_area\" style=\"text-align:center;\"><input type=\"button\" value=\"添 加\" class=\"input_button1\" onclick=\"save()\"/></div>\r\n");
      out.write("            <input type=\"submit\" id=\"formSubmit\" style=\"display:none\"/>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction save() {\r\n");
      out.write("\t\tvar form = document.getElementById(\"addForm\");\r\n");
      out.write("\t\tvar className = document.getElementById(\"className\").value;\r\n");
      out.write("\t\tvar classContent = FCKeditorAPI.GetInstance(\"classContent\").GetXHTML(true);\r\n");
      out.write("\t\tvar simpleContent = FCKeditorAPI.GetInstance(\"simpleContent\").GetXHTML(true);\r\n");
      out.write("\t\tif (className == \"\") {\r\n");
      out.write("\t\t\talert(\"请输入数据!\");\r\n");
      out.write("\t\t\treturn\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tform.action = \"admin_class_type.php?action=add\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"formSubmit\").click();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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
