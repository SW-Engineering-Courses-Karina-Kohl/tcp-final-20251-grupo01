SRC_DIR=src
BIN_DIR=bin
LIB_DIR=lib
MAIN_CLASS=app.Main

JSOUP_JAR=$(LIB_DIR)/jsoup-1.19.1.jar
JUNIT_JAR=$(LIB_DIR)/junit-platform-console-standalone-1.11.0.jar

SOURCES=$(shell find $(SRC_DIR) -name "*.java" ! -name "subjectManager.java")

all: main

main:
	mkdir -p $(BIN_DIR)
	javac -cp "$(JSOUP_JAR)" -d $(BIN_DIR) $(filter-out $(SRC_DIR)/test/%.java, $(SOURCES))

test: main
	mkdir -p $(BIN_DIR)
	javac -cp "$(JSOUP_JAR):$(JUNIT_JAR):$(BIN_DIR)" -d $(BIN_DIR) $(SRC_DIR)/test/*.java
	java -jar $(JUNIT_JAR) --class-path $(BIN_DIR) --scan-class-path

run: main
	java -cp "$(BIN_DIR):$(JSOUP_JAR)" $(MAIN_CLASS)

clean:
	rm -rf $(BIN_DIR)/*

.PHONY: all main test run clean