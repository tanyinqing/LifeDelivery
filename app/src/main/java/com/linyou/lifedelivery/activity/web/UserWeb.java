package com.linyou.lifedelivery.activity.web;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.http.RequestParams;
import com.linyou.lifedelivery.activity.ceshi.PromptManager;
import com.linyou.lifedelivery.activity.ceshi.p;
import com.linyou.lifedelivery.activity.entity.TouXiang;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.impl.IUserWeb;
import com.linyou.lifedelivery.activity.listener.DataListener;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class UserWeb extends BaseWeb implements IUserWeb {

    private Context context;

    public UserWeb(Context context) {
        super(context);
        this.context=context;
    }

    private static String UserUrl = BaseUrl + "/user/";

    /**
     * 登陆
     */
    private static String LoginUrl = UserUrl + "login.do";
    /**
     * 注册
     */
    private static String RegisterUrl = GuoBaseUrl + "/user/" + "register.do";
    /**
     * 修改用户信息
     */
    private static String ModifyUserInfoUrl = UserUrl +"modifyUserInfo.do";
    /**
     * 上传头像
     */
    private static String UploadHeadUrl = UserUrl + "uploadHeadPortrait.do";

    /**
     * 验证码
     */
    private static String CodeUrl = UserUrl + "obtainPhoneCode.do";
    /**
     * 修改密码
     */
    private static String ModifyPasswordUrl = UserUrl +"modifyPassword.do";

    /**
     * 获取验证码
     *
     * @param phoneNum
     * @param dataListener
     */
    public void getCode(String phoneNum,final DataListener<String> dataListener)
    {
        mPrefUtil.putSetting("PhoneCode",1);
        PromptManager.showDialogTest(context, CodeUrl+"    "+"phoneNum   "+phoneNum);
        RequestParams params = new RequestParams();
        params.addBodyParameter("phoneNum", phoneNum);
        post(CodeUrl, params, new IRequestListener() {
            public void onSuccess(String json) {
                Type type = new TypeToken<String>(){}.getType();
                parse(json,type, dataListener);
            }
            @Override
            public void onFailed() {
                dataListener.onFailed();
            }
        });
    }

    /**
     * 用户登录
     *
     * @param phoneNum
     * @param password
     * @param dataListener
     */
    public void login(String phoneNum, String password,
                      final DataListener<User> dataListener) {
        PromptManager.showDialogTest(context, LoginUrl + "    " + "phoneNum   " + phoneNum + "      " + "password   " + password);
        RequestParams params = new RequestParams();
        params.addBodyParameter("phoneNum", phoneNum);
        params.addBodyParameter("password", password);
        post(LoginUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                String json1="{\n" +
                        "    \"data\": {\n" +
                        "        \"age\": 15,\n" +
                        "        \"email\": \"dd@fg\",\n" +
                        "        \"gender\": 2,\n" +
                        "        \"logins\": 42,\n" +
                        "        \"password\": \"e10adc3949ba59abbe56e057f20f883e\",\n" +
                        "        \"photoMob\": \"\",\n" +
                        "        \"portrait\": \"data/files/head/20160307142606.jpg\",\n" +
                        "        \"realName\": \"1111\",\n" +
                        "        \"regTime\": 0,\n" +
                        "        \"userId\": 479,\n" +
                        "        \"userName\": \"15132146262\"\n" +
                        "    },\n" +
                        "    \"msg\": \"登陆成功！\",\n" +
                        "    \"success\": true\n" +
                        "}\n";
                Type type = new TypeToken<User>(){}.getType();
                parse(json,type, dataListener);
            }
            @Override
            public void onFailed() {
               /* String json1="{\n" +
                        "    \"data\": {\n" +
                        "        \"age\": 15,\n" +
                        "        \"email\": \"dd@fg\",\n" +
                        "        \"gender\": 2,\n" +
                        "        \"logins\": 42,\n" +
                        "        \"password\": \"e10adc3949ba59abbe56e057f20f883e\",\n" +
                        "        \"photoMob\": \"\",\n" +
                        "        \"portrait\": \"data/files/head/20160307142606.jpg\",\n" +
                        "        \"realName\": \"1111\",\n" +
                        "        \"regTime\": 0,\n" +
                        "        \"userId\": 479,\n" +
                        "        \"userName\": \"15132146262\"\n" +
                        "    },\n" +
                        "    \"msg\": \"登陆成功！\",\n" +
                        "    \"success\": true\n" +
                        "}\n";
                Type type = new TypeToken<User>(){}.getType();
                parse(json1, type, dataListener);*/
                //dataListener.onFailed();
            }
        });
    }

    /**
     * 用户注册
     *
     * @param phoneNum
     * @param password
     * @param dataListener
     */
    public void register(String password, String phoneNum,
                         String phoneCode, String type,
                         final DataListener<User> dataListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("password", password);
        params.addBodyParameter("phoneNum", phoneNum);
        params.addBodyParameter("phoneCode", phoneCode);
        params.addBodyParameter("type", type);

        p.L("注册是携带的参数", RegisterUrl + " " + password + "  " + phoneNum + "  " + phoneCode);
        post(RegisterUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                Type type = new TypeToken<User>() {
                }.getType();
                parse(json, type, dataListener);
            }

            @Override
            public void onFailed() {
                dataListener.onFailed();
            }
        });
    }

    @Override
    public void modifyUserInfo(String id, String nickName,
                               String email, String age, String sex, final DataListener<User> dataListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("id", id);
        params.addBodyParameter("nickName", nickName);
        params.addBodyParameter("email", email);
        params.addBodyParameter("age", age);
        params.addBodyParameter("sex", sex);

        PromptManager.showDialogTest(context, ModifyUserInfoUrl + "    " + "id   " + id + "      " + "nickName   " + nickName +
                "      " + "email  " + email + "      " + "age  " + age + "      " + "sex  " + sex + "      ");

        post(ModifyUserInfoUrl, params, new IRequestListener() {

            public void onSuccess(String json) {
                PromptManager.showDialogTest(context,json);
                Type type = new TypeToken<User>() {
                }.getType();
                parse(json, type, dataListener);
            }
            @Override
            public void onFailed() {
                dataListener.onFailed();
            }
        });
    }

    /*这个是上传头像的操作*/
    @Override
    public void uploadHeadPortrait(String file, String fileFileName,
                                   String userId, final DataListener<TouXiang> dataListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("file", file);
        params.addBodyParameter("fileFileName", fileFileName);
        params.addBodyParameter("userId", userId);
        p.L("上传头像的操作", fileFileName + "  " + userId + " 图片的编码文件  " + " 省略");
        p.s(file);
        //System.out.println("String file=   " + file);

		/*//写一个模拟的操作，把这个文件存储下来
		File file1=new File(Environment.getExternalStorageDirectory(),"tan.jpg");
		try {
			FileInputStream is=new FileInputStream(file);
			FileOutputStream fos=new FileOutputStream(file1);
			int count=0;
			byte[] buffer=new byte[1024];
			while ((count=is.read(buffer))!=-1){
			fos.write(buffer,0,count);
				p.L("正在复制头像",String.valueOf(count));
			}
			fos.close();
			is.close();
		}catch (Exception e){
			p.L("异常",e.toString());
		}*/


        post(UploadHeadUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                p.L("上传头像返回的数据", json);
                Type type = new TypeToken<TouXiang>() {
                }.getType();
                //String json1="{\"data\":{\"wangZhi\":\"data/files/head/20160215105918.jpg\"},\"msg\":\"上传成功！\",\"success\":true}";
                parse(json, type, dataListener);

            }

            @Override
            public void onFailed() {
                dataListener.onFailed();
            }
        });
    }


       @Override
    public void modifyPassword(String id, String oldPassword,
                               String newPassword, final DataListener dataListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("id", id);
        params.addBodyParameter("oldPassword", oldPassword);
        params.addBodyParameter("newPassword", newPassword);
        p.L("修改密码时打印的参数",ModifyPasswordUrl+"  "+id+"  "+oldPassword+"  "+newPassword);
        post(ModifyPasswordUrl, params, new IRequestListener() {

            public void onSuccess(String json) {
                parse(json, dataListener);
            }

            @Override
            public void onFailed() {
                dataListener.onFailed();
            }
        });
    }
}
