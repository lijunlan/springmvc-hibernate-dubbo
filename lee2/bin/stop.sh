#! /bin/bash

jps -lm | grep Starter | cut -d" " -f1 | xargs kill
