// Get the current row index
def rowIndex = vars.get("rowIndex").toInteger()

// Read the CSV row (skip header by adding 1 to index)
def csvData = ${__readCSV(${__property(user.dir)}/output.csv,${rowIndex},",")}

// Split the row into variables
def (id, name, email) = csvData.split(",")
vars.put("id", id.replaceAll('"', '')) // Remove quotes
vars.put("name", name.replaceAll('"', ''))
vars.put("email", email.replaceAll('"', ''))
log.info("Read CSV row ${rowIndex}: id=${id}, name=${name}, email=${email}")
