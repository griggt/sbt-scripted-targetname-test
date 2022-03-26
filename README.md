An sbt scripted test that passes despite failing to run.

The misbehavior is new to sbt 1.6.x, it behaves as expected on 1.5.x.

To reproduce:

```
$ git clone https://github.com/griggt/sbt-scripted-targetname-test.git

$ cd sbt-scripted-targetname-test

$ sbt scripted

[info] welcome to sbt 1.6.2 (AdoptOpenJDK Java 1.8.0_292)
[info] loading global plugins from /home/tgrigg/.sbt/1.0/plugins
[info] loading project definition from /tmp/sbt-scripted-targetname-test/project
[info] loading settings for project root from build.sbt ...
[info] set current project to root (in build file:/tmp/sbt-scripted-targetname-test/)
[info] Wrote /tmp/sbt-scripted-targetname-test/target/scala-2.12/sbt-1.0/root-0.1.0-SNAPSHOT.pom
[info] :: delivering :: root#root;0.1.0-SNAPSHOT :: 0.1.0-SNAPSHOT :: integration :: Sat Mar 26 16:21:02 PDT 2022
[info] 	delivering ivy file to /tmp/sbt-scripted-targetname-test/target/scala-2.12/sbt-1.0/ivy-0.1.0-SNAPSHOT.xml
[info] 	published root to /home/tgrigg/.ivy2/local/root/root/scala_2.12/sbt_1.0/0.1.0-SNAPSHOT/poms/root.pom
[info] 	published root to /home/tgrigg/.ivy2/local/root/root/scala_2.12/sbt_1.0/0.1.0-SNAPSHOT/jars/root.jar
[info] 	published root to /home/tgrigg/.ivy2/local/root/root/scala_2.12/sbt_1.0/0.1.0-SNAPSHOT/srcs/root-sources.jar
[info] 	published root to /home/tgrigg/.ivy2/local/root/root/scala_2.12/sbt_1.0/0.1.0-SNAPSHOT/docs/root-javadoc.jar
[info] 	published ivy to /home/tgrigg/.ivy2/local/root/root/scala_2.12/sbt_1.0/0.1.0-SNAPSHOT/ivys/ivy.xml
[info] Running 1 / 1 (100.00%) scripted tests with RunFromSourceMain
[info] Running foo/targetName
[error] [info] [launcher] getting org.scala-sbt sbt 1.6.2  (this may take some time)...
[error] [info] [launcher] getting Scala 2.12.15 (for sbt)...
[info] [info] Updated file /tmp/sbt_1cba3190/project/build.properties: set sbt.version to 1.6.2
[info] [info] welcome to sbt 1.6.2 (AdoptOpenJDK Java 1.8.0_292)
[info] [info] loading project definition from /tmp/sbt_1cba3190/project
[info] [info] loading settings for project sbt_1cba3190 from build.sbt ...
[info] [info] set current project to sbt_1cba3190 (in build file:/tmp/sbt_1cba3190/)
[info] [info] welcome to sbt 1.6.2 (AdoptOpenJDK Java 1.8.0_292)
[info] [info] loading project definition from /tmp/sbt_1cba3190/project
[info] [info] loading settings for project sbt_1cba3190 from build.sbt ...
[info] [info] set current project to sbt_1cba3190 (in build file:/tmp/sbt_1cba3190/)
[info] [info] compiling 2 Scala sources to /tmp/sbt_1cba3190/target/scala-3.1.1/classes ...
[info] [info] done compiling
[info] [info] running B
[info] [success] Total time: 4 s, completed Mar 26, 2022 4:21:17 PM
[info] [info] compiling 1 Scala source to /tmp/sbt_1cba3190/target/scala-3.1.1/classes ...
[info] [info] done compiling
[info] [info] running B
[error] Exception in thread "sbt-bg-threads-2" java.lang.NoClassDefFoundError: C
[error] 	at B$.main(B.scala:2)
[error] 	at B.main(B.scala)
[error] 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
[error] 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
[error] 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
[error] 	at java.lang.reflect.Method.invoke(Method.java:498)
[error] 	at sbt.Run.invokeMain(Run.scala:143)
[error] 	at sbt.Run.execute$1(Run.scala:93)
[error] 	at sbt.Run.$anonfun$runWithLoader$5(Run.scala:120)
[error] 	at sbt.Run$.executeSuccess(Run.scala:186)
[error] 	at sbt.Run.runWithLoader(Run.scala:120)
[error] 	at sbt.Defaults$.$anonfun$bgRunTask$6(Defaults.scala:1983)
[error] 	at sbt.Defaults$.$anonfun$termWrapper$2(Defaults.scala:1922)
[error] 	at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
[error] 	at scala.util.Try$.apply(Try.scala:213)
[error] 	at sbt.internal.BackgroundThreadPool$BackgroundRunnable.run(DefaultBackgroundJobService.scala:369)
[error] 	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
[error] 	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
[error] 	at java.lang.Thread.run(Thread.java:748)
[error] Caused by: java.lang.ClassNotFoundException: C
[error] 	at java.net.URLClassLoader.findClass(URLClassLoader.java:382)
[error] 	at sbt.internal.ManagedClassLoader.findClass(ManagedClassLoader.java:102)
[error] 	at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
[error] 	at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
[error] 	... 19 more
[info] [success] Total time: 1 s, completed Mar 26, 2022 4:21:18 PM
[info] + foo/targetName
```