name := "HelloScala"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies ++= Seq("io.spray"           %% "spray-json"         % "1.3.2",
                            "org.scalatest"      %  "scalatest_2.11"     % "3.0.1",
                            "com.squants"        %  "squants_2.10"       % "0.2.3",
                            "org.apache.spark"   % "spark-core_2.11"     % "2.1.1"
)

libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.1.1"
