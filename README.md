## FileProvider 相关说明

FileProvider 是一个特殊的 ContentProvider 的子类，它使用 content:// Uri 代替了 file:/// Uri. ，更便利而且安全的为另一个app分享文件。

1. 声明 FileProvider

```xml
<provider
	android:name="android.support.v4.content.FileProvider"
	android:authorities="vip.kassadin.camerademo.fileprovider"
	android:exported="false"
	android:grantUriPermissions="true">
	<meta-data
		android:name="android.support.FILE_PROVIDER_PATHS"
		android:resource="@xml/file_paths"></meta-data>
</provider>
```

2. 指定可用目录

```
<paths>
    <files-path path="images/" name="myimages" />
</paths>
```

path=“images/” 就是你所要共享的文件路径。

name="myimages" 就是告诉FileProvider 用 myimages 添加进URIs 内容字段去访问 files/images/ 的子目录。

在这个文件中，为每个目录添加一个XML元素指定目录。

|标签|对应方法|基础路路径|
| ---- | :---: | ---|
|1|2|3|
| files-path | getFilesDir | /data/data/vip.kassadin.camerademo/files |
| cache-path | getCacheDir | /data/data/vip.kassadin.camerademo/cache |
| external-path | Environment.getExternalStorageDirectory|/storage/emulated/0 |
| external-files-path | getExternalFilesDir(String) getExternalFilesDir(null) | /storage/emulated/0/Android/data/vip.kassadin.camerademo/files |
| external-cache-path | Context.getExternalCacheDir() | /storage/emulated/0/Android/data/vip.kassadin.camerademo/cache |
| root-path || / |

3. 获取文件Uri

```
File imagePath = new File(Context.getFilesDir(), "images");
File newFile = new File(imagePath, "default_image.jpg");
Uri contentUri = getUriForFile(getContext(), "vip.kassadin.camerademo.fileprovider", newFile);
```

返回值就是:
content://vip.kassadin.camerademo.fileprovider/my_images/default_image.jpg


[官方文档](https://developer.android.com/reference/android/support/v4/content/FileProvider.html)

[FileProvider共享文件、缓存](http://www.jianshu.com/p/cb61847acb38)

[Android7.0须知--应用间共享文件（FileProvider）](http://www.jianshu.com/p/3f9e3fc38eae)

[FileProvider无法获取外置SD卡问题解决方案 | Failed to find configured root that contains](http://www.jianshu.com/p/121bbb07cb07)