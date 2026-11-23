# Copy this file with the command `cp secrets-template.sh secrets.sh`
# DO NOT COMMIT THIS FILE. Make sure it is never tracked before committing
# Fill in the blanks with the actual Supabase credentials in the copied file (NOT IN THE TEMPLATE)

export REMOTE_USERNAME="postgres.YourProjectRef"
export REMOTE_PASSWORD="YourPassword"
# YourUrlRegion shoud look something like aws-1-us-west-2
export REMOTE_URL="jdbc:postgresql://YourUrlRegion.pooler.supabase.com:5432/postgres"