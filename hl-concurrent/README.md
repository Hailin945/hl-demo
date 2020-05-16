Java 同步锁synchronized

synchronized锁的是资源（数据），更准确的来说锁的是对资源的操作（比如HashTable的get、put等方法），每次操作都必须拿到响应的锁，  
代码synchronized（this）{ ... } 中synchronized代表锁，this代表锁的名字，Java中每个对象都可以作为唯一的一把锁。同一个对象  
代表的锁锁住的资源操作同时只能有一个被进入。比如HashTable的get和put方法，都是HashTable锁，所以不仅同时只有一个线程可以进入get
方法，而且一条线程进入get方法后，其他线程也不能进入put方法。