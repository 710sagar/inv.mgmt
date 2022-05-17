# inv.mgmt
Inventory Management Project Spring
END POINTS
  Inventory Controller
    /saveItem
      For adding inventory items - Post Request - Body parameter - Name, Desc, Price, Qty
    /deleteItem/{stock_id}
      For deleting particular inventory item - Get Request - Param accepted - Stock_id that needs to be deleted
    /edit/{stock_id}
      For editing particular inventory item - Put Request - Param accepted - Stock_id that needs to be edited
    /getAll
      For getting all inventory items - Get Request
    /get/{stock_id}
      For retreiving particular inventory id - Get Request - Param accepted - Stock_id 
  
   Warehouse Controller
    /insertWarehouse
      For adding warehouse - Post Request - Body Parameters - warehouse_id, warehouse name
   
   Mapping Controller
    /insertMapping
      For assigning warehouse to stock - Post Request - Body Parameters - warehouse_id, Stock_id
