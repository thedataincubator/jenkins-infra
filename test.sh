#!/bin/bash
if [[ `detect-secrets scan | jq -r ".results" | jq length` == 1 ]]; then 
  exit 0 
else
  exit 1 
fi
