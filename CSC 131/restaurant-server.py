# Youssef Boujebha
# 10/20/2023
# Homework 3, REST api's
from flask import Flask, request, jsonify

app = Flask(__name__)

PORT = 8080
HOST = "127.0.0.1"

User_data = [
    {"id": 1, "name": "Youssef", "type": "Owner"},
    {"id": 2, "name": "Gunther", "type": "Chef"}    # User info
]
Recipe_data = [
    {"id": 1, "User_id": 1, "Steps": "Bake cookies"},  # Recipe info
    {"id": 2, "User_id": 2, "Steps": "Bake bread"}
]
def _find_next_id(data_list):
    max_id = 0
    for data in data_list:
        if data["id"] > max_id:
            max_id = data["id"]

    # Calculate the next ID
    next_id = max_id + 1
    return next_id

@app.route("/restaurant/users", methods=["GET"]) # Returns the info of all users
def get_user_data():
    if len(User_data) == 0:
        return {"error": "No users found"}, 404 # Returns error code if there are no users
    return jsonify(User_data)

@app.route("/restaurant/users/:user_id", methods=["GET"]) # Only returns the current user's data (Only the first one)
def get_current_user():
    if len(User_data) == 0:
        return {"error": "No users found"}, 404 # Returns error code if there are no users
    return jsonify(User_data[0])

@app.route("/restaurant/users", methods=["POST"])
def add_user_data():
    if request.is_json:
        response = request.get_json()
        response["id"] = _find_next_id(User_data)
        User_data.append(response)
        return jsonify(response), 201

    return {"error": "Request must be JSON"}, 404

@app.route("/restaurant/users/:user_id", methods=["PUT"])  # Allows you to edit user data
def edit_user_data(user_id):
    data = request.json()
    user_to_edit = next((user for user in User_data if user['id'] == user_id))

    if user_to_edit is None:    # Error if there are no users to edit
        return jsonify({"error": "User not found"}), 404

    user_to_edit.update(data)
    return jsonify({"Success":"Data updated"})  # Message to know it worked

@app.route("/restaurant/users/:user_id", methods=["DELETE"])  # Deletes an existing user
def delete_user_data(user_id):
    user_to_remove = next((index for index, user in enumerate(User_data) if user['id'] == user_id), None)

    if user_to_remove is None:
        return jsonify({"error": "No user found"}), 404  # Error message is no user is found
    deleted_user = User_data.pop(user_to_remove) # pops the user from the list

    return jsonify({"Sucess": "User data has been deleted"})

@app.route("/restaurant/users/:user_id/recipes/:recipe_id", methods=["GET"])  # Returns the current users recipe
def get_current_recipe():
    if len(Recipe_data) is None:
        return {"error": "No Recipe list"}, 404  # Returns error code if the recipe list doesn't exist
    return jsonify(Recipe_data[0])

@app.route("/restaurant/users/:user_id/recipes", methods=["GET"]) # Returns the info of all recipes
def get_user_recipes():
    if len(Recipe_data) is None:
        return {"error": "No recipe list"}, 404  # Returns error code if a recipe list doesn't exist
    return jsonify(Recipe_data)

@app.route("/restaurant/users/:user_id/recipes", methods=["POST"])  # Allows you to add recipes
def add_recipe_data():
    if request.is_json:
        response = request.get_json()
        response["id"] = _find_next_id(Recipe_data)
        Recipe_data.append(response)
        return jsonify(response), 201

    return {"error": "Request must be JSON"}, 404

@app.route("/restaurant/users/:user_id/recipes/:recipe_id", methods=["PUT"])  # Allows you to edit user recipes
def edit_recipe_data(user_id):
    data = request.json()
    recipe_to_edit = next((user for user in Recipe_data if user['id'] == user_id))

    if recipe_to_edit is None:    # Error if there are no recipes to edit
        return jsonify({"error": "Recipe not found"}), 404
    recipe_to_edit.update(data)

    return jsonify({"Success": "Recipe updated"})  # Message to know it worked

@app.route("/restaurant/users/:user_id/recipes/:recipe_id", methods=["DELETE"])  # Deletes an existing recipe
def delete_recipe_data(user_id):
    recipe_to_remove = next((index for index, user in enumerate(Recipe_data) if user['id'] == user_id), None)

    if recipe_to_remove is None:
        return jsonify({"error": "No recipe found"}), 404  # Error message is no recipe is found

    deleted_recipe = Recipe_data.pop(recipe_to_remove)  # pops the recipe from the list
    return jsonify({"Success": "Recipe data has been deleted"})

if __name__ == '__main__':  # What keeps the server running on loop
    app.run(host=HOST, port=PORT)
