#!/bin/sh
#
# Gradle start up script for UN*X
#

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

DIRNAME=`dirname "$0"`
cd "$DIRNAME" >/dev/null
APP_HOME=`pwd -P`
cd - >/dev/null

MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

if [ "$APP_HOME" = "" ] ; then
    APP_HOME="."
fi

CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

JAVACMD="java"
if [ -n "$JAVA_HOME" ] ; then
    JAVACMD="$JAVA_HOME/bin/java"
fi

exec "$JAVACMD" \
    -classpath "$CLASSPATH" \
    org.gradle.wrapper.GradleWrapperMain \
    "$@"
