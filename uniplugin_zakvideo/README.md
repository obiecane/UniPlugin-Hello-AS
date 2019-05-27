纯原生实现的播放器插件, 目前支持全屏播放, 左半屏上下滑动控制亮度, 右半屏上下滑动控制音量, 左右滑动快退快进

目前只支持android, 并且**只支持在nvue页面中使用**

# 使用教程

### 使用方式

```vue
<zakvideo 
	auto-play="true" 
	src="http://vfx.mtime.cn/Video/2019/03/19/mp4/190319212559089721.mp4"
	cover="http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640">
</zakvideo>
```

### 属性说明

| 属性名    | 类型    | 默认值 | 可选参数    | 说明         |
| --------- | ------- | ------ | ----------- | ------------ |
| auto-play | boolean | false  | true, false | 是否自动播放 |
| src       | string  |        |             | 视频地址     |
| cover     | string  |        |             | 封面地址     |

## 后记

1. 目前本插件不能根据高度调整控件位置和视频高度

