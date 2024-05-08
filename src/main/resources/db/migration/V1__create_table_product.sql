CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    owner_id TEXT NOT NULL,
    name TEXT NOT NULL,
    category TEXT NOT NULL,
    shop_id TEXT,
    price INTEGER NOT NULL, 
    promotion_price INTEGER,
    description TEXT, 
    image TEXT,  
    quantity INTEGER NOT NULL,
    is_available BOOLEAN NOT NULL
);