package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.lang.reflect.*;
public class EntityListTagHandler extends BodyTagSupport
{
private List list;
private int index;
private String populatorClass;
private String populatorMethod;
private String name;
public EntityListTagHandler()
{
this.reset();
}
public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}
public String getPopulatorClass()
{
return this.populatorClass;
}
public void setPopulatorMethod(String populatorMethod)
{
this.populatorMethod=populatorMethod;
}
public String getPopulatorMethod()
{
return this.populatorMethod;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
private void reset()
{
this.list=null;
this.index=0;
this.populatorClass=null;
this.populatorMethod=null;
this.name=null;
}
public int doStartTag()
{
try
{
if(this.name==null || this.name.trim().length()==0) return super.SKIP_BODY;
Class c=Class.forName(this.populatorClass);
Object obj=c.newInstance();
Class parameters[]=new Class[0];
Method method=c.getMethod(this.populatorMethod,parameters);
this.list=(List)method.invoke(obj);
if(this.list==null || this.list.size()==0) return super.SKIP_BODY;
Object bean=this.list.get(this.index);
pageContext.setAttribute(this.name,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",(this.index+1),PageContext.REQUEST_SCOPE);
this.index++;
return super.EVAL_BODY_INCLUDE;
}catch(Throwable t)
{
return super.SKIP_BODY;
}
}
public int doAfterBody()
{
if(this.index==this.list.size()) return super.SKIP_BODY;
Object bean=this.list.get(this.index);
pageContext.setAttribute(this.name,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",(this.index+1),PageContext.REQUEST_SCOPE);
this.index++;
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}