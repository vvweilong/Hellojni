#include <jni.h>
#include <string>

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_oo_hellojni_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

//显示名字 字符串用法 无参数
JNIEXPORT jstring JNICALL
Java_com_oo_hellojni_MainActivity_showName(
        JNIEnv *env,
        jobject /*this*/) {
    std::string result = "my name is JNI";
    return env->NewStringUTF(result.c_str());
}
//计算加法
JNIEXPORT jint JNICALL
Java_com_oo_hellojni_MainActivity_add(JNIEnv, jobject, jint x, jint y) {
    return x + y;
}

//计算减法
JNIEXPORT jint JNICALL
Java_com_oo_hellojni_MainActivity_sub(JNIEnv, jobject, jint x, jint y) {
    return x - y;
}

//计算乘法
JNIEXPORT jint JNICALL
Java_com_oo_hellojni_MainActivity_mul(JNIEnv, jobject, jint x, jint y) {
    return x * y;
}

//计算除法
JNIEXPORT jint JNICALL
Java_com_oo_hellojni_MainActivity_dev(JNIEnv, jobject, jint x, jint y) {
    return x / y;
}


}

