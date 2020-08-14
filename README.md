# SomeLibrary


当前通用最新版本：
[![](https://jitpack.io/v/licheedev/SomeLibrary.svg)](https://jitpack.io/#licheedev/SomeLibrary)





```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}


def somelib_version = "1.2.0"
// 包含myutils、clickablebg、rxjava2ex、rxjava3ex、widgets
implementation "com.github.licheedev.SomeLibrary:base:$somelib_version"
// 其他组件
implementation "com.github.licheedev.SomeLibrary:myutils:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:statuslayout:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:clickablebg:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:widgets:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:context:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:rxjava2ex:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:rxjava3ex:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:rateview:$somelib_version"
implementation "com.github.licheedev.SomeLibrary:labelview:$somelib_version"
```

编译失败就加入：
```
android {
    ...
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```

# 其他常用依赖
Jetpack
> https://developer.android.google.cn/jetpack/androidx/explorer?hl=zh-cn

Lifecycle
> https://developer.android.google.cn/jetpack/androidx/releases/lifecycle?hl=zh-cn#declaring_dependencies

数据绑定
> https://developer.android.google.cn/topic/libraries/data-binding/start?hl=zh-cn
```gradle
android {
        ...
        dataBinding {
            enabled = true
        }
    }
```

Glide
> https://github.com/bumptech/glide
```gradle
implementation 'com.github.bumptech.glide:glide:4.11.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
```


