plugins {
    id("java")
}

group = "it.unibo.bd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // This dependency is exported to consumers, that is to say found on their compile classpath.
    // api("org.apache.commons:commons-math3:3.6.1")
    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:31.1-jre")
    // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-common
    implementation("org.apache.hadoop:hadoop-common:3.3.4")
    // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-client
    implementation("org.apache.hadoop:hadoop-client:3.3.4")
    // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-hdfs
    implementation("org.apache.hadoop:hadoop-hdfs:3.3.4")
    // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-mapreduce-client-core
    implementation("org.apache.hadoop:hadoop-mapreduce-client-core:3.3.4")
    // https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-aws
    implementation("org.apache.hadoop:hadoop-aws:3.3.4")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}