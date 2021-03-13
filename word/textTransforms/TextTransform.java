package java_advanced.polymorphism.word.textTransforms;

public interface TextTransform {
    void invokeOn(StringBuilder text, int startIndex, int endIndex);
}
