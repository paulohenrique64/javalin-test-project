#!/bin/bash
firefox ./frontend/index.html &
./backend/mvnw -f ./backend/pom.xml compile exec:java

