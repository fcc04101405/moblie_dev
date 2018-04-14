## ActionBar

ActionBar是一个确定用户位置的窗口功能，并且能提供用户操作和导航的模块。使用ActionBar能够为用户提供一个熟悉的界面进行界面的切换，这个切换能够使系统更优雅是适应不同屏幕的配置。

## ActionBar提供以下几个重要的功能：

1. 提供一个专属的空间给你的应用，标志和显示用户在应用程序中的位置。
2. 在可预测的方法中，让重要的操作更加突出和易操作（例如搜索）。
3. 支持内部一致的导航和视图切换应用程序(用标签或下拉列表)

## 常规的ActionBar

ActionBar将空间分为4个不同的区域以适应大多数的App 
![这里写图片描述](http://img.blog.csdn.net/20160725122412148) 
\1. App icon 
你的app应用的身份标志，如果你愿意你可以替换成其他的logo。重要的： 
如果你的app现在没有显示最顶层的界面，请确保显示插入了左边符号的app的icon,这样用户才能知道你的app应用层级结构。 
\2. View control 
如果你的应用程序在不同的视图显示数据,这部分的操作栏允许用户切换视图。例如：view-switching控制下拉菜单或选项卡控件。 
如果你的应用程序不支持不同的视图，你也可以使用这个空间来显示非交互式内容,比如应用程序标题或更长时间的品牌信息。 
\3. Action Buttons 
显示应用程序中最重要的那部分动作行为。操作栏中放不下的Action就会自动转移到Action overflow。长按图标查看行动的名字。 
\4. Action overflow 
不太常用的Action就会放到这里。

## 适应旋转和不同大小的屏幕

在UI问题中，其中最重要的一个问题就是怎样在创建app时适应旋转和不同大小的屏幕。 
你可以使用split action bars去适应这些变化，使用split action bars允许你将ActionBar中的Action分到其他的bar中，如main action bar或者是屏幕的底部。 
![这里写图片描述](http://img.blog.csdn.net/20160725142733430)

## 使用Split Action Bar的注意事项

当将操作栏的acton bar分到多个acton bar时，你可以有三个位置使用：

1. Main action bar

2. Top bar

3. Bottom bar

   位置如下图所示： 
   ![这里写图片描述](http://img.blog.csdn.net/20160725143415339) 
   如果用户可以从给定的屏幕定位到app的层次结构，main action bar 至少包含up caret（-_-! 不知道怎么翻译啊）。

   应用程序提供的允许用户在视图之间快速切换,在top bar 中使用tab或者spinner。

为了显示action，如有必要，可以在bottom bar中使用action overflow。

## Action Buttons

Action Buttons是ActionBar里面操作应用程序最重要的Activity。考虑到那些button会经常使用，于是让它们排列有顺序。根据可用的屏幕空间,系统显示了你最重要的Action Buttons中的操作，其他的Action Buttons将移动到Action overflow中。ActionBar中应该只显示用户可用的Action。如果一个Action在当前环境中不可用,那就隐藏它。将其设为不可用，并不且不显示这些Action Buttons。 
Gmail应用程序中的一些Action Buttons 
![这里写图片描述](http://img.blog.csdn.net/20160726142521547)

在对于选择那些Action作为ActionBar上的Action Buttons,可以参考FIT原则。

1. F—–Frequent
2. I——Important
3. T—–Typical

## Toolbar

Toolbar是Android 5.0中新引入的一个控件，其出现的目的就是为了取代ActionBar。

> 注意，如果使用Toolbar替代ActionBar，你只能使用Theme.AppCompat中没有ActionBar的主题或者直接继承Activity，否则会造成冲突出错！

ToolBar直接使用 setSupportActionBar(toolbar);来替代ActionBar，这是使用V7兼容包的方式，如果是5.0以上可以直接使用setActionBar();

### 使用toolbar后改变overflow中背景的颜色：

```
app:popupTheme="@style/PopupMenu"1
```

```
<style name="PopupMenu" parent="ThemeOverlay.AppCompat.Light" >
        <item name="android:colorBackground">#ffffff</item>
        <item name="android:textColor">#0000ff</item>
</style>1234
```

### 显示overflow中的图标

```
/**
     * 显示 OverFlow 中的图标
     */
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }123456789101112131415161718
```

### 在toolbar中使用ActionMode

说白了，ActionMode就是临时占据了ActionBar的位置。

```
startSupportActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuItem saveItem = menu.add("add").setIcon(R.drawable.icon);
                MenuItemCompat.setShowAsAction(saveItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);

                MenuItem searchItem = menu.add("del").setIcon(R.drawable.icon);
                MenuItemCompat.setShowAsAction(searchItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);

                MenuItem refreshItem = menu.add("que").setIcon(R.drawable.icon);
                MenuItemCompat.setShowAsAction(refreshItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                mode.finish();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });1234567891011121314151617181920212223242526272829303132
```

上面的方法中，onCreateActionMode() 方法是对Mode的初始化，onActionItemClicked() 就是对于与ActionMode的Item点击事件的监听。

> 注意，在主题中加入 
> `<item name="windowActionModeOverlay">true</item>` 
> 否则会同时出现actionmode和toolbar共存的情况。