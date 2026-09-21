// Create Database Products
use(
	"gadgetStore",
);
// Create Collection
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.createCollection(
	"products",
	{
		validator:
			{
				$jsonSchema:
					{
						bsonType:
							"object",
						required:
							[
								"name",
								"price",
								"inStock",
							],
						additionalProperties: true,
						properties:
							{
								name: {
									bsonType:
										"string",
									description:
										"must be a string and is required",
								},
								price: {
									bsonType:
										[
											"int",
											"double",
										],
									description:
										"price must be an integer or double",
								},
								inStock:
									{
										bsonType:
											"bool",
										description:
											"wether the product is in stock, must be a boolean",
									},
							},
					},
			},
		validationAction:
			"error",
	},
);

// Insert mock data
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.insertMany(
	[
		{
			name: "Wireless Mouse",
			price: 25.99,
			inStock: true,
		},
		{
			name: "Keyboard",
			price: 19.99,
			inStock: true,
		},
		{
			name: "Headset",
			price: 59.99,
			inStock: true,
		},
		{
			name: "Game Console",
			price: 499.99,
			inStock: false,
		},
		{
			name: "Mouse",
			price: 25.99,
			inStock: true,
			specs: {
				brand: "Logitech",
			},
		},
	],
);

// See collection in DB
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.getCollectionNames();
// See all rows in DB
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.find();

// Invalid inserts

// Insert with missing stock
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.insertOne(
	{
		name: "Switch",
		price: 995.99,
		specs: {
			brand: "Logitech",
		},
	},
);

// Insert with missing name
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.insertOne(
	{
		price: 12.99,
		inStock: false,
		specs: {
			brand: "Logitech",
		},
	},
);

// Insert with wrong data type
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.insertOne(
	{
		name: "Steam Machine",
		price: "340.99",
		inStock: false,
		specs: {
			brand: "Logitech",
		},
	},
);

// Update Headset Record
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);

gadgetStore.products.updateOne(
	{
		name: "Headset",
	},
	{
		$set: {
			category:
				"Accessories",
		},
	},
);
gadgetStore.products.updateOne(
	{
		name: "Headset",
	},
	{
		$inc: {
			price: 15,
		},
	},
);

// Push tags array to row
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.updateOne(
	{
		name: "Headset",
	},
	{
		$push: {
			tags: "wireless",
		},
	},
);
gadgetStore.products.updateOne(
	{
		name: "Headset",
	},
	{
		$push: {
			tags: "bestseller",
		},
	},
);
gadgetStore.products.find();

// Pull wireless from the tags
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.updateOne(
	{
		name: "Headset",
	},
	{
		$pull: {
			tags: "wireless",
		},
	},
);
gadgetStore.products.find();

// Find all products with a price over $40
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.find(
	{
		price: {
			$gte: 40,
		},
	},
	{
		name: 1,
		price: 1,
		inStock: 1,
	},
);

// Find all products made by Logitech
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.find(
	{
		"specs.brand":
			"Logitech",
	},
	{
		name: 1,
		price: 1,
		inStock: 1,
	},
);

// Find all products with category in ['Accessories']
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.products.find(
	{
		category:
			{
				$in: [
					"Accessories",
				],
			},
	},
	{
		name: 1,
		price: 1,
		inStock: 1,
	},
);

// Create Second Collection Orders
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.createCollection(
	"orders",
	{
		validator:
			{
				$jsonSchema:
					{
						bsonType:
							"object",
						required:
							[
								"product_id",
								"quantity",
							],
						additionalProperties: true,
						properties:
							{
								product_id:
									{
										bsonType:
											"objectId",
										description:
											"a reference to a product",
									},
								quantity:
									{
										bsonType:
											"int",
										description:
											"an integer representing the number of order of the product",
									},
							},
					},
			},
		validationAction:
			"error",
	},
);

// Insert order into orders table
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
const headSet =
	gadgetStore.products.findOne(
		{
			name: "Headset",
		},
	);
gadgetStore.orders.insertOne(
	{
		product_id:
			headSet._id,
		quantity: 2,
	},
);
gadgetStore.orders.find();

// Perform join and print values
const gadgetStore =
	db.getSiblingDB(
		"gadgetStore",
	);
gadgetStore.orders.aggregate(
	[
		{
			$lookup:
				{
					from: "products",
					localField:
						"product_id",
					foreignField:
						"_id",
					as: "product",
				},
		},
		{
			$unwind:
				"$product",
		},
		{
			$project:
				{
					_id: 0,
					product:
						"$product.name",
					quantity: 1,
				},
		},
	],
);
