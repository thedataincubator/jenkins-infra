#!/bin/bash
if [[ `detect-secrets scan | jq -r ".results"` == "{}" ]]; then 
  exit 0 
else
  exit 1 
fi
