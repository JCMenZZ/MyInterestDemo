package cn.jcmenzz.tolearn.moocbd.exam;

/**
 * 一个简单的新闻事件侦听演示程序
 *
 * @author tds
 * @author 修改者：
 */
public class Week5 {
    public static void main(String[] args) {
        //模拟有一家新闻社
        NewsAgency bbc = new NewsAgency("BBC");
        //订阅该社的新闻
        bbc.addListener(new MyListener());
        //TODO 请在这里再加入一个Listener
        bbc.addListener(new Listener() {
            @Override
            public void newsArrived(NewsEvent e) {
                if (e.level > 5) {
                    System.out.println("warning:2");
                }
                System.out.println("please note," + e.text + " happed!");
            }
        });
        //TODO 请在这里再加入一个Listener并用lambda表达式表示
        bbc.addListener(e -> {
            if (e.level > 5) {
                System.out.println("warning:3");
            }
            System.out.println("please note," + e.text + " happed!");
        });
        //新闻社启动其工作流程
        bbc.start();
    }
}

/**
 * 事件信息
 */
class NewsEvent {
    Object source;
    String text;
    int level;

    /**
     * @param source 事件来源
     * @param text   事件内容
     * @param level  事件级别
     */
    NewsEvent(Object source, String text, int level) {
        this.source = source;
        this.text = text;
        this.level = level;
    }
}

interface Listener {
    /**
     * 抽象方法
     *
     * @param e 新闻事件对象
     */
    void newsArrived(NewsEvent e);
}

/**
 * 新闻机构
 */
class NewsAgency {
    String name;

    /**
     * @param name 机构名
     */
    public NewsAgency(String name) {
        this.name = name;
    }

    /**
     * 侦听者（订阅者）
     */
    Listener[] listeners = new Listener[100];
    /**
     * 已有的订阅者
     */
    int listenerCnt = 0;

    /**
     * 加入一个订阅者
     *
     * @param oneListener
     */
    void addListener(Listener oneListener) {
        if (listenerCnt < listeners.length) {
            listeners[listenerCnt] = oneListener;
            listenerCnt++;
        }
    }

    /**
     * 模拟一个事件发生，并通知所有的订阅者
     */
    void start() {
        NewsEvent event = new NewsEvent("Mr. Joan", "Bombing", 9);
        for (int i = 0; i < listenerCnt; i++) {
            listeners[i].newsArrived(event);
        }
    }
}

/**
 * 实现一个订阅者
 */
class MyListener implements Listener {
    /**
     * 当接收到消息后，进行一些显示
     *
     * @param e 新闻事件对象
     */
    @Override
    public void newsArrived(NewsEvent e) {
        if (e.level > 5) System.out.println("warning :");
        System.out.println("please note," + e.text + " happed!");
    }
}
