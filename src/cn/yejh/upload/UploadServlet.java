package cn.yejh.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author yejh
 * @create 2019-09_29 14:11
 */
@WebServlet(value="/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("utf8");
        response.setContentType("text/html; charset=UTF-8");


        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
                //限制文件大小
                servletFileUpload.setSizeMax(300*1024);

                List<FileItem> fileItems = servletFileUpload.parseRequest(request);

                Iterator<FileItem> iterator = fileItems.iterator();
                while(iterator.hasNext()){
                    FileItem item = iterator.next();
                    String itemName = item.getFieldName();
                    int sno = -1;
                    String sname = null;
                    if(item.isFormField()){
                        if("sno".equals(itemName)){
                            sno = Integer.parseInt(item.getString("utf-8"));
                        }else if("sname".equals(itemName)){
                            sname = item.getString("utf-8");
                        }
                    }else{
                        String fileName = item.getName();
                        //String path = request.getSession().getServletContext().getRealPath("/JspProj");
                        //System.out.println(path);

                        String ext = fileName.substring(fileName.indexOf('.')+1);

                        //限制后缀名
                        if(!("pgn".equals(ext) || "jpg".equals(ext) || "gif".equals(ext))){
                            System.out.println("上传图片格式仅限pgn、jpg、gif");
                            return;
                        }


                        File file = new File("C:\\javaweb\\upload", fileName);
                        item.write(file);
                        System.out.println(fileName + "上传成功");
                    }
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e){
            e.printStackTrace();
        } catch(FileUploadException e) {
            e.printStackTrace();
            System.out.println("上传的文件不得大于300kb");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
