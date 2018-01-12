#!/usr/bin/env bash

url=`./deploy-function.sh` && curl ${url}\?id\=1234
